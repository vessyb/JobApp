package com.company.dbo.jobapplicationdatabase.dbo.userapplicationlog.generated;

import com.company.dbo.jobapplicationdatabase.dbo.userapplicationlog.UserApplicationLog;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.manager.Manager;
import com.speedment.runtime.field.Field;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * The generated base interface for the manager of every {@link
 * com.company.dbo.jobapplicationdatabase.dbo.userapplicationlog.UserApplicationLog}
 * entity.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedUserApplicationLogManager extends Manager<UserApplicationLog> {
    
    TableIdentifier<UserApplicationLog> IDENTIFIER = TableIdentifier.of("JobApplicationDatabase", "dbo", "UserApplicationLog");
    List<Field<UserApplicationLog>> FIELDS = unmodifiableList(asList(
        UserApplicationLog.USER_ACCOUNT_ID,
        UserApplicationLog.JOB_POST_ID
    ));
    
    @Override
    default Class<UserApplicationLog> getEntityClass() {
        return UserApplicationLog.class;
    }
}