package com.company.dbo.jobapplicationdatabase.dbo.useraccount.generated;

import com.company.dbo.jobapplicationdatabase.dbo.useraccount.UserAccount;
import com.company.dbo.jobapplicationdatabase.dbo.useraccount.UserAccountEntityStoreSerializerImpl;
import com.company.dbo.jobapplicationdatabase.dbo.useraccount.UserAccountManager;
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
 * UserAccountManager}.
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
public final class GeneratedUserAccountCacheHolder implements EntityStoreHolder<UserAccount> {
    
    private final EntityStore<UserAccount> entityStore;
    private final OfInt fieldIdCache;
    private final OfInt fieldUserTypeIdCache;
    private final OfString fieldNameCache;
    private final OfString fieldEmailCache;
    private final OfString fieldPasswordCache;
    
    public GeneratedUserAccountCacheHolder(
            EntityStore<UserAccount> entityStore,
            OfInt fieldIdCache,
            OfInt fieldUserTypeIdCache,
            OfString fieldNameCache,
            OfString fieldEmailCache,
            OfString fieldPasswordCache) {
        
        this.entityStore          = requireNonNull(entityStore);
        this.fieldIdCache         = requireNonNull(fieldIdCache);
        this.fieldUserTypeIdCache = requireNonNull(fieldUserTypeIdCache);
        this.fieldNameCache       = requireNonNull(fieldNameCache);
        this.fieldEmailCache      = requireNonNull(fieldEmailCache);
        this.fieldPasswordCache   = requireNonNull(fieldPasswordCache);
    }
    
    @Override
    public EntityStore<UserAccount> getEntityStore() {
        return entityStore;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <CACHE extends FieldCache<CACHE>> CACHE getFieldCache(ColumnIdentifier<UserAccount> columnId) {
        if (columnId instanceof UserAccount.Identifier) {
            final UserAccount.Identifier _id = (UserAccount.Identifier) columnId;
            switch (_id) {
                case ID           : return (CACHE) fieldIdCache;
                case USER_TYPE_ID : return (CACHE) fieldUserTypeIdCache;
                case NAME         : return (CACHE) fieldNameCache;
                case EMAIL        : return (CACHE) fieldEmailCache;
                case PASSWORD     : return (CACHE) fieldPasswordCache;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = columnId.getColumnId();
            switch (_colName) {
                case "id"         : return (CACHE) fieldIdCache;
                case "userTypeId" : return (CACHE) fieldUserTypeIdCache;
                case "name"       : return (CACHE) fieldNameCache;
                case "email"      : return (CACHE) fieldEmailCache;
                case "password"   : return (CACHE) fieldPasswordCache;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public boolean isHavingMultiFieldCache(ColumnIdentifier<UserAccount> columnId) {
        return false;
    }
    
    public static CompletableFuture<GeneratedUserAccountCacheHolder> reload(StreamSupplierComponent streamSupplier, ExecutorService executor) {
        return reload(DataStoreHolderUtil.buildEntityStore(
            streamSupplier,
            executor,
            UserAccountEntityStoreSerializerImpl::new,
            TableIdentifier.of("JobApplicationDatabase", "dbo", "UserAccount")
        ), executor);
    }
    
    @Override
    public EntityStoreHolder<UserAccount> recycleAndPersist(PersistOperation<UserAccount> persistOperation) {
        return wrapped().recycleAndPersist(persistOperation);
    }
    
    @Override
    public EntityStoreHolder<UserAccount> recycleAndRemove(RemoveOperation<UserAccount> removeOperation) {
        return wrapped().recycleAndRemove(removeOperation);
    }
    
    @Override
    public EntityStoreHolder<UserAccount> recycleAndUpdate(UpdateOperation<UserAccount> updateOperation) {
        return wrapped().recycleAndUpdate(updateOperation);
    }
    
    private EntityStoreHolder<UserAccount> wrapped() {
        // Use explicit type for Stream to improve compilation time.
        final Map<ColumnLabel, FieldCache<?>> fieldCaches = Stream.<Tuple2<HasIdentifier<UserAccount>, FieldCache<?>>>of(
            Tuples.of(UserAccount.ID,          fieldIdCache),
            Tuples.of(UserAccount.USER_TYPE_ID,fieldUserTypeIdCache),
            Tuples.of(UserAccount.NAME,        fieldNameCache),
            Tuples.of(UserAccount.EMAIL,       fieldEmailCache),
            Tuples.of(UserAccount.PASSWORD,    fieldPasswordCache)
        )
            .collect(toMap(t2 -> t2.get0().identifier().label(), Tuple2::get1));
        final Map<ColumnLabel,  Map<ColumnLabel, MultiFieldCache<?, ?, ?>>>  multiFieldCaches = createMultiCacheMap();
        final Set<ColumnIdentifier<UserAccount>> columnIdentifiers = Stream.<HasIdentifier<UserAccount>>of(
            UserAccount.ID,
            UserAccount.USER_TYPE_ID,
            UserAccount.NAME,
            UserAccount.EMAIL,
            UserAccount.PASSWORD
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
    
    public static CompletableFuture<GeneratedUserAccountCacheHolder> reload(CompletableFuture<EntityStore<UserAccount>> entityStoreFuture, ExecutorService executor) {
        final CompletableFuture<FieldCache.OfInt> fieldIdCacheFuture =
            DataStoreHolderUtil.buildIntCache(entityStoreFuture, executor, UserAccount.ID, 0);
        
        final CompletableFuture<FieldCache.OfInt> fieldUserTypeIdCacheFuture =
            DataStoreHolderUtil.buildIntCache(entityStoreFuture, executor, UserAccount.USER_TYPE_ID, 0);
        
        final CompletableFuture<FieldCache.OfString> fieldNameCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, UserAccount.NAME, 0);
        
        final CompletableFuture<FieldCache.OfString> fieldEmailCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, UserAccount.EMAIL, 0);
        
        final CompletableFuture<FieldCache.OfString> fieldPasswordCacheFuture =
            DataStoreHolderUtil.buildStringCache(entityStoreFuture, executor, UserAccount.PASSWORD, 0);
        
        return entityStoreFuture.thenApplyAsync(entityStore -> {
            try {
                return new GeneratedUserAccountCacheHolder(
                    entityStore,
                    fieldIdCacheFuture.get(),
                    fieldUserTypeIdCacheFuture.get(),
                    fieldNameCacheFuture.get(),
                    fieldEmailCacheFuture.get(),
                    fieldPasswordCacheFuture.get()
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
        fieldUserTypeIdCache.close();
        fieldNameCache.close();
        fieldEmailCache.close();
        fieldPasswordCache.close();
    }
    
    @Override
    public Statistics getStatistics() {
        return StatisticsUtil.getStatistics(    
            this,
            entityStore.identifier(),
            Arrays.asList(
                UserAccount.Identifier.ID,
                UserAccount.Identifier.USER_TYPE_ID,
                UserAccount.Identifier.NAME,
                UserAccount.Identifier.EMAIL,
                UserAccount.Identifier.PASSWORD
            )
        
        );
    }
    
    private Map<ColumnLabel, Map<ColumnLabel, MultiFieldCache<?, ?, ?>>> createMultiCacheMap() {
        return Collections.emptyMap();
    }
}