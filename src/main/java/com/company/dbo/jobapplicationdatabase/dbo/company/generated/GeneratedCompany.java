package com.company.dbo.jobapplicationdatabase.dbo.company.generated;

import com.company.dbo.jobapplicationdatabase.dbo.company.Company;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.enterprise.datastore.runtime.field.DatastoreFields;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.field.IntField;
import com.speedment.runtime.field.StringField;
import com.speedment.runtime.typemapper.TypeMapper;

/**
 * The generated base for the {@link
 * com.company.dbo.jobapplicationdatabase.dbo.company.Company}-interface
 * representing entities of the {@code Company}-table in the database.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public interface GeneratedCompany {
    
    /**
     * This Field corresponds to the {@link Company} field that can be obtained
     * using the {@link Company#getId()} method.
     */
    IntField<Company, Integer> ID = DatastoreFields.createIntField(
        Identifier.ID,
        Company::getId,
        Company::setId,
        TypeMapper.primitive(),
        true
    );
    /**
     * This Field corresponds to the {@link Company} field that can be obtained
     * using the {@link Company#getName()} method.
     */
    StringField<Company, String> NAME = DatastoreFields.createStringField(
        Identifier.NAME,
        Company::getName,
        Company::setName,
        TypeMapper.identity(),
        false
    );
    
    /**
     * Returns the id of this Company. The id field corresponds to the database
     * column JobApplicationDatabase.dbo.Company.id.
     * 
     * @return the id of this Company
     */
    int getId();
    
    /**
     * Returns the name of this Company. The name field corresponds to the
     * database column JobApplicationDatabase.dbo.Company.name.
     * 
     * @return the name of this Company
     */
    String getName();
    
    /**
     * Sets the id of this Company. The id field corresponds to the database
     * column JobApplicationDatabase.dbo.Company.id.
     * 
     * @param id to set of this Company
     * @return   this Company instance
     */
    Company setId(int id);
    
    /**
     * Sets the name of this Company. The name field corresponds to the database
     * column JobApplicationDatabase.dbo.Company.name.
     * 
     * @param name to set of this Company
     * @return     this Company instance
     */
    Company setName(String name);
    
    enum Identifier implements ColumnIdentifier<Company> {
        
        ID   ("id"),
        NAME ("name");
        
        private final String columnId;
        private final TableIdentifier<Company> tableIdentifier;
        
        Identifier(String columnId) {
            this.columnId        = columnId;
            this.tableIdentifier = TableIdentifier.of(    getDbmsId(), 
                getSchemaId(), 
                getTableId());
        }
        
        @Override
        public String getDbmsId() {
            return "JobApplicationDatabase";
        }
        
        @Override
        public String getSchemaId() {
            return "dbo";
        }
        
        @Override
        public String getTableId() {
            return "Company";
        }
        
        @Override
        public String getColumnId() {
            return this.columnId;
        }
        
        @Override
        public TableIdentifier<Company> asTableIdentifier() {
            return this.tableIdentifier;
        }
    }
}