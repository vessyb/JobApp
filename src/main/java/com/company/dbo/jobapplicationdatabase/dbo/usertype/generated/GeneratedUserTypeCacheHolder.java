package com.company.dbo.jobapplicationdatabase.dbo.usertype.generated;

import com.company.dbo.jobapplicationdatabase.dbo.usertype.UserType;
import com.company.dbo.jobapplicationdatabase.dbo.usertype.UserTypeEntityStoreSerializerImpl;
import com.company.dbo.jobapplicationdatabase.dbo.usertype.UserTypeManager;
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
 * UserTypeManager}.
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
public final class GeneratedUserTypeCacheHolder implements EntityStoreHolder<UserType> {
    
    private final EntityStore<UserType> entityStore;
    private final OfInt fieldIdCache;
    private final OfString fieldTypeCache;
    
    public GeneratedUserTypeCacheHolder(
            EntityStore<UserType> entityStore,
            OfInt fieldIdCache,
            OfString fieldTypeCache) {
        
        this.entityStore    = requireNonNull(entityStore);
        this.fieldIdCache   = requireNonNull(fieldIdCache);
        this.fieldTypeCache = requireNonNull(fieldTypeCache);
    }
    
    @Override
    public EntityStore<UserType> getEntityStore() {
        return entityStore;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <CACHE extends FieldCache<CACHE>> CACHE getFieldCache(ColumnIdentifier<UserType> columnId) {
        if (columnId instanceof UserType.Identifier) {
            final UserType.Identifier _id = (UserType.Identifier) columnId;
            switch (_id) {
                case ID   : return (CACHE) fieldIdCache;
                case TYPE : return (CACHE) fieldTypeCache;
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
                case "type" : return (CACHE) fieldTypeCache;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public boolean isHavingMultiFieldCache(ColumnIdentifier<UserType> columnId) {
        return false;
    }
    
    public static CompletableFuture<GeneratedUserTypeCacheHolder> reload(StreamSupplierComponent streamSupplier, ExecutorService executor) {
        return reload(DataStoreHolderUtil.buildEntityStore(
            streamSupplier,
            executor,
            UserTypeEntityStoreSerializerImpl::new,
            TableIdentifier.of("JobApplicationDatabase", "dbo", "UserType")
        ), executor);
    }
    
    @Override
    public EntityStoreHolder<UserType> recycleAndPersist(PersistOperation<UserType> persistOperation) {
        return wrapped().recycleAndPersist(persistOperation);
    }
    
    @Override
    public EntityStoreHolder<UserType> recycleAndRemove(RemoveOperation<UserType> removeOperation) {
        return wrapped().recycleAndRemove(removeOperation);
    }
    
    @Override
    public EntityStoreHolder<UserType> recycleAndUpdate(UpdateOperation<UserType> updateOperation) {
        return wrapped().recycleAndUpdate(updateOperation);
    }
    
    private EntityStoreHolder<UserType> wrapped() {
        // Use explicit type for Stream to improve compilation time.
        final Map<ColumnLabel, FieldCache<?>> fieldCaches = Stream.<Tuple2<HasIdentifier<UserType>, FieldCache<?>>>of(
            Tuples.of(UserType.ID,  fieldIdCache),
            Tuples.of(UserType.TYPE,fieldTypeCache)
        )
            .collect(toMap(t2 -> t2.get0().identifier().label(), Tuple2::get1));
        final Map<ColumnLabel,  Map<ColumnLabel, MultiFieldCache<?, ?, ?>>>  multiFieldCaches = createMultiCacheMap();
        final Set<ColumnIdentifier<UserType>> columnIdentifiers = Stream.<HasIdentifier<UserType>>of(
            UserType.ID,
            UserType.TYPE
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
    
    public static CompletableFuture<GeneratedUserTypeCacheHolder> reload(CompletableFuture<EntityStore<UserType>> entityStoreFuture, ExecutorService executor) {
        final CompletableFuture<FieldCache.OfInt> fieldIdCacheFuture =
            DataStoreHolderUtil.buildIntCache(entityStoreFuture, executor, UserType.ID, 0);
        
        final CompletableFuture<FieldCache.OfString> fieldTypeCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, UserType.TYPE, 0);
        
        return entityStoreFuture.thenApplyAsync(entityStore -> {
            try {
                return new GeneratedUserTypeCacheHolder(
                    entityStore,
                    fieldIdCacheFuture.get(),
                    fieldTypeCacheFuture.get()
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
        fieldTypeCache.close();
    }
    
    @Override
    public Statistics getStatistics() {
        return StatisticsUtil.getStatistics(    
            this,
            entityStore.identifier(),
            Arrays.asList(
                UserType.Identifier.ID,
                UserType.Identifier.TYPE
            )
        
        );
    }
    
    private Map<ColumnLabel, Map<ColumnLabel, MultiFieldCache<?, ?, ?>>> createMultiCacheMap() {
        return Collections.emptyMap();
    }
}