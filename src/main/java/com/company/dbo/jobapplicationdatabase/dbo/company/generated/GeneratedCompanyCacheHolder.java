package com.company.dbo.jobapplicationdatabase.dbo.company.generated;

import com.company.dbo.jobapplicationdatabase.dbo.company.Company;
import com.company.dbo.jobapplicationdatabase.dbo.company.CompanyEntityStoreSerializerImpl;
import com.company.dbo.jobapplicationdatabase.dbo.company.CompanyManager;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStore;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStoreHolder;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache.OfInt;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache.OfString;
import com.speedment.enterprise.datastore.runtime.fieldcache.FieldCache;
import com.speedment.enterprise.datastore.runtime.fieldcache.MultiFieldCache;
import com.speedment.enterprise.datastore.runtime.statistic.Statistics;
import com.speedment.enterprise.datastore.runtime.util.DataStoreHolderUtil;
import com.speedment.enterprise.datastore.runtime.util.StatisticsUtil;
import com.speedment.runtime.bulk.PersistOperation;
import com.speedment.runtime.bulk.RemoveOperation;
import com.speedment.runtime.bulk.UpdateOperation;
import com.speedment.runtime.config.identifier.ColumnIdentifier;
import com.speedment.runtime.config.identifier.ColumnLabel;
import com.speedment.runtime.config.identifier.TableIdentifier;
import com.speedment.runtime.core.component.StreamSupplierComponent;
import com.speedment.runtime.field.Field;
import com.speedment.runtime.field.trait.HasIdentifier;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * A holder class for the various caches that are used to speed up the {@link
 * CompanyManager}.
 * 
 * Generated by
 * com.speedment.enterprise.datastore.generator.internal.code.GeneratedEntityCacheHolderTranslator
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public final class GeneratedCompanyCacheHolder implements EntityStoreHolder<Company> {
    
    private final EntityStore<Company> entityStore;
    private final OfInt fieldIdCache;
    private final OfString fieldNameCache;
    
    public GeneratedCompanyCacheHolder(
            EntityStore<Company> entityStore,
            OfInt fieldIdCache,
            OfString fieldNameCache) {
        
        this.entityStore    = requireNonNull(entityStore);
        this.fieldIdCache   = requireNonNull(fieldIdCache);
        this.fieldNameCache = requireNonNull(fieldNameCache);
    }
    
    @Override
    public EntityStore<Company> getEntityStore() {
        return entityStore;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <CACHE extends FieldCache<CACHE>> CACHE getFieldCache(ColumnIdentifier<Company> columnId) {
        if (columnId instanceof Company.Identifier) {
            final Company.Identifier _id = (Company.Identifier) columnId;
            switch (_id) {
                case ID   : return (CACHE) fieldIdCache;
                case NAME : return (CACHE) fieldNameCache;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = columnId.getColumnId();
            switch (_colName) {
                case "id"   : return (CACHE) fieldIdCache;
                case "name" : return (CACHE) fieldNameCache;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public boolean isHavingMultiFieldCache(ColumnIdentifier<Company> columnId) {
        return false;
    }
    
    public static CompletableFuture<GeneratedCompanyCacheHolder> reload(StreamSupplierComponent streamSupplier, ExecutorService executor) {
        return reload(DataStoreHolderUtil.buildEntityStore(
            streamSupplier,
            executor,
            CompanyEntityStoreSerializerImpl::new,
            TableIdentifier.of("JobApplicationDatabase", "dbo", "Company")
        ), executor);
    }
    
    @Override
    public EntityStoreHolder<Company> recycleAndPersist(PersistOperation<Company> persistOperation) {
        return wrapped().recycleAndPersist(persistOperation);
    }
    
    @Override
    public EntityStoreHolder<Company> recycleAndRemove(RemoveOperation<Company> removeOperation) {
        return wrapped().recycleAndRemove(removeOperation);
    }
    
    @Override
    public EntityStoreHolder<Company> recycleAndUpdate(UpdateOperation<Company> updateOperation) {
        return wrapped().recycleAndUpdate(updateOperation);
    }
    
    private EntityStoreHolder<Company> wrapped() {
        // Use explicit type for Stream to improve compilation time.
        final Map<ColumnLabel, FieldCache<?>> fieldCaches = Stream.<Tuple2<HasIdentifier<Company>, FieldCache<?>>>of(
            Tuples.of(Company.ID,  fieldIdCache),
            Tuples.of(Company.NAME,fieldNameCache)
        )
            .collect(toMap(t2 -> t2.get0().identifier().label(), Tuple2::get1));
        final Map<ColumnLabel,  Map<ColumnLabel, MultiFieldCache<?, ?, ?>>>  multiFieldCaches = createMultiCacheMap();
        final Set<ColumnIdentifier<Company>> columnIdentifiers = Stream.<HasIdentifier<Company>>of(
            Company.ID,
            Company.NAME
        )
            .map(HasIdentifier::identifier)
            .collect(toSet());
        return EntityStoreHolder.of(
            entityStore,
            fieldCaches,
            multiFieldCaches,
            columnIdentifiers
        );
    }
    
    public static CompletableFuture<GeneratedCompanyCacheHolder> reload(CompletableFuture<EntityStore<Company>> entityStoreFuture, ExecutorService executor) {
        final CompletableFuture<FieldCache.OfInt> fieldIdCacheFuture =
            DataStoreHolderUtil.buildIntCache(entityStoreFuture, executor, Company.ID, 0);
        
        final CompletableFuture<FieldCache.OfString> fieldNameCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, Company.NAME, 0);
        
        return entityStoreFuture.thenApplyAsync(entityStore -> {
            try {
                return new GeneratedCompanyCacheHolder(
                    entityStore,
                    fieldIdCacheFuture.get(),
                    fieldNameCacheFuture.get()
                );
            } catch (final ExecutionException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    
    @Override
    public void close() {
        entityStore.close();
        fieldIdCache.close();
        fieldNameCache.close();
    }
    
    @Override
    public Statistics getStatistics() {
        return StatisticsUtil.getStatistics(    
            this,
            entityStore.identifier(),
            Arrays.asList(
                Company.Identifier.ID,
                Company.Identifier.NAME
            )
        
        );
    }
    
    private Map<ColumnLabel, Map<ColumnLabel, MultiFieldCache<?, ?, ?>>> createMultiCacheMap() {
        return Collections.emptyMap();
    }
}