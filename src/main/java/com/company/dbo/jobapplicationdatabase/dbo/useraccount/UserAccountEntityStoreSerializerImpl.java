package com.company.dbo.jobapplicationdatabase.dbo.useraccount;

import com.company.dbo.jobapplicationdatabase.dbo.useraccount.generated.GeneratedUserAccountEntityStoreSerializerImpl;

import java.nio.ByteBuffer;
import java.util.function.LongFunction;
import java.util.function.LongToIntFunction;

/**
 * An {@link
 * com.speedment.enterprise.datastore.runtime.entitystore.EntityStoreSerializer}
 * class for table {@link com.speedment.runtime.config.Table} named UserAccount.
 * <p>
 * This file is safe to edit. It will not be overwritten by the code generator.
 * 
 * @author company
 */
public final class UserAccountEntityStoreSerializerImpl extends GeneratedUserAccountEntityStoreSerializerImpl {
    
    public UserAccountEntityStoreSerializerImpl(LongFunction<ByteBuffer> bufferFinder, LongToIntFunction offsetFinder) {
        super(bufferFinder, offsetFinder);
    }
}