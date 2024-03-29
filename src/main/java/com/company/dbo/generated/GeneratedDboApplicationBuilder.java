package com.company.dbo.generated;

import com.company.dbo.DboApplication;
import com.company.dbo.DboApplicationBuilder;
import com.company.dbo.DboApplicationImpl;
import com.company.dbo.DboCacheReloader;
import com.company.dbo.jobapplicationdatabase.dbo.company.CompanyManagerImpl;
import com.company.dbo.jobapplicationdatabase.dbo.company.CompanySqlAdapter;
import com.company.dbo.jobapplicationdatabase.dbo.jobpost.JobPostManagerImpl;
import com.company.dbo.jobapplicationdatabase.dbo.jobpost.JobPostSqlAdapter;
import com.company.dbo.jobapplicationdatabase.dbo.jobtype.JobTypeManagerImpl;
import com.company.dbo.jobapplicationdatabase.dbo.jobtype.JobTypeSqlAdapter;
import com.company.dbo.jobapplicationdatabase.dbo.useraccount.UserAccountManagerImpl;
import com.company.dbo.jobapplicationdatabase.dbo.useraccount.UserAccountSqlAdapter;
import com.company.dbo.jobapplicationdatabase.dbo.userapplicationlog.UserApplicationLogManagerImpl;
import com.company.dbo.jobapplicationdatabase.dbo.userapplicationlog.UserApplicationLogSqlAdapter;
import com.company.dbo.jobapplicationdatabase.dbo.usertype.UserTypeManagerImpl;
import com.company.dbo.jobapplicationdatabase.dbo.usertype.UserTypeSqlAdapter;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.injector.Injector;
import com.speedment.runtime.application.AbstractApplicationBuilder;

/**
 * A generated base {@link
 * com.speedment.runtime.application.AbstractApplicationBuilder} class for the
 * {@link com.speedment.runtime.config.Project} named dbo.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedDboApplicationBuilder extends AbstractApplicationBuilder<DboApplication, DboApplicationBuilder> {
    
    protected GeneratedDboApplicationBuilder() {
        super(DboApplicationImpl.class, GeneratedDboMetadata.class);
        withManager(CompanyManagerImpl.class);
        withManager(JobPostManagerImpl.class);
        withManager(JobTypeManagerImpl.class);
        withManager(UserAccountManagerImpl.class);
        withManager(UserApplicationLogManagerImpl.class);
        withManager(UserTypeManagerImpl.class);
        withComponent(CompanySqlAdapter.class);
        withComponent(JobPostSqlAdapter.class);
        withComponent(JobTypeSqlAdapter.class);
        withComponent(UserAccountSqlAdapter.class);
        withComponent(UserApplicationLogSqlAdapter.class);
        withComponent(UserTypeSqlAdapter.class);
        withComponent(DboCacheReloader.class);
    }
    
    @Override
    public DboApplication build(Injector injector) {
        return injector.getOrThrow(DboApplication.class);
    }
}