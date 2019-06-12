package com.company.dbo;

import com.company.dbo.jobapplicationdatabase.dbo.company.Company;
import com.company.dbo.jobapplicationdatabase.dbo.company.CompanyManager;
import com.company.dbo.jobapplicationdatabase.dbo.jobpost.JobPost;
import com.company.dbo.jobapplicationdatabase.dbo.jobpost.JobPostImpl;
import com.company.dbo.jobapplicationdatabase.dbo.jobpost.JobPostManager;
import com.company.dbo.jobapplicationdatabase.dbo.jobtype.JobType;
import com.company.dbo.jobapplicationdatabase.dbo.jobtype.JobTypeManager;
import com.company.dbo.jobapplicationdatabase.dbo.useraccount.UserAccount;
import com.company.dbo.jobapplicationdatabase.dbo.useraccount.UserAccountImpl;
import com.company.dbo.jobapplicationdatabase.dbo.useraccount.UserAccountManager;
import com.company.dbo.jobapplicationdatabase.dbo.userapplicationlog.UserApplicationLog;
import com.company.dbo.jobapplicationdatabase.dbo.userapplicationlog.UserApplicationLogImpl;
import com.company.dbo.jobapplicationdatabase.dbo.userapplicationlog.UserApplicationLogManager;
import com.company.dbo.jobapplicationdatabase.dbo.usertype.UserTypeManager;
import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;
import com.speedment.enterprise.datastore.runtime.DataStoreBundle;
import com.speedment.enterprise.datastore.runtime.DataStoreComponent;
import com.speedment.runtime.core.exception.SpeedmentException;
import com.speedment.runtime.core.manager.FieldSet;
import com.speedment.runtime.core.manager.Persister;
import com.speedment.runtime.core.manager.Updater;
import com.speedment.runtime.join.Join;
import com.speedment.runtime.join.JoinComponent;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 @author vesela
 @apiNote I've got missing configuration files, which I don't know how to fix on my own,
            I had issues with Hibernate and couldn't connect it to any database,
            I made this project, using Speedment, which I would consider as "work smart, not hard",
            but without being able to run my program and see where it breaks, I cannot write and learn it properly.
            The program below is just based on my inner logic. (or lack thereof :D)*/

public class Main {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        DboApplication app = new DboApplicationBuilder()
                .withPassword("D!videandconquer38")
                .withBundle(DataStoreBundle.class)
                .build();

        app.getOrThrow(DataStoreComponent.class)
                .load();

        //business logic
        UserAccountManager userAccountManager = app.getOrThrow(UserAccountManager.class);
        JobTypeManager jobTypeManager = app.getOrThrow(JobTypeManager.class);
        JobPostManager jobPostManager = app.getOrThrow(JobPostManager.class);
        CompanyManager companyManager = app.getOrThrow(CompanyManager.class);
        UserApplicationLogManager userApplicationLogManager = app.getOrThrow(UserApplicationLogManager.class);
        UserTypeManager userTypeManager = app.getOrThrow(UserTypeManager.class);
        JoinComponent joinComponent = app.getOrThrow(JoinComponent.class);

        Persister<JobPost> jobPostManagerPersister = jobPostManager.persister();
        Persister<UserAccount> userAccountPersister = userAccountManager.persister();
        Persister<UserApplicationLog> userApplicationLogPersister = userApplicationLogManager.persister();
        Updater<UserApplicationLog> userApplicationLogUpdater = userApplicationLogManager.updater();
        Updater<JobPost> jobPostUpdater = jobPostManager.updater(FieldSet.of(JobPost.IS_ACTIVE));

        System.out.println("What do you want to do?\n" +
                "If you want to register your candidate account, press 1\n" +
                "If you want to post a job, press 2\n" +
                "If you want to see how many active offers are available, press 3\n");

        int choice = SCANNER.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter your email:");
                String email = SCANNER.nextLine();
                System.out.println("Enter what job you want to apply for:");
                String jobOffer = SCANNER.nextLine();

                try {
                    //creates user account by given email
                    Stream.of(email)
                            .map(e -> new UserAccountImpl()
                                    .setUserTypeId(2)
                                    .setEmail(email)
                                    .setName("Gosho")
                                    .setPassword("123"))
                            .forEach(userAccountPersister);

                    //returns the just created user account ^
                    Optional<UserAccount> ua = userAccountManager.stream()
                            .filter(UserAccount.EMAIL.equal(email))
                            .findAny();

                    //joins jobtype and jobpost
                    Join<Tuple2<JobType, JobPost>> join = joinComponent.from(JobTypeManager.IDENTIFIER)
                            .innerJoinOn(JobPost.JOB_TYPE_ID).equal(JobType.ID)
                            .build(Tuples::of);

                    //getting a single instance of job type
                    Optional<JobType> jobIdOptional = jobTypeManager.stream()
                            .filter(JobType.JOB_TYPE.equal(jobOffer))
                            .findAny();

                    //trying to insert into the log table
                    jobPostManager.stream()
                            .filter(JobPost.IS_ACTIVE)
                            .map(e -> new UserApplicationLogImpl().setJobPostId(jobIdOptional.get().getId())
                                    .setUserAccountId(ua.get().getId()))
                            .forEach(userApplicationLogPersister);

                    //setting applied to previously active offers to inactive
                    jobPostManager.stream()
                            .filter(JobPost.ID.equal(jobIdOptional.get().getId()))
                            .map(JobPost.IS_ACTIVE.setTo(false))
                            .forEach(jobPostUpdater);
                } catch (SpeedmentException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                System.out.println("Enter your company's name to post job offering:");
                String companyName = SCANNER.nextLine();

                //posts new job offer, has some hardcoded things :(
                companyManager.stream()
                        .filter(Company.NAME.equal(companyName))
                        .map(company -> new JobPostImpl()
                                .setCompanyId(company.getId())
                                .setIsActive(true)
                                .setJobDescription("some description")
                                .setJobTypeId(2))
                        .forEach(jobPostManagerPersister);
                break;
            case 3:
                //counts how many job posts are active
                long count = jobPostManager.stream()
                        .filter(JobPost.IS_ACTIVE)
                        .count();
                System.out.println("Number of active job posts: " + count);

                break;

        }

        SCANNER.close();
        app.close();
    }


}
