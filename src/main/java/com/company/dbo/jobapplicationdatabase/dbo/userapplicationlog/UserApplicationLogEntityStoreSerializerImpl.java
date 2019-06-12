package com.company.dbo.jobapplicationdatabase.dbo.userapplicationlog;

import com.company.dbo.jobapplicationdatabase.dbo.userapplicationlog.generated.GeneratedUserApplicationLogEntityStoreSerializerImpl;

import java.nio.ByteBuffer;
import java.util.function.LongFunction;
import java.util.function.LongToIntFunction;

/**
 * An {@link
 * com.speedment.enterprise.datastore.runtime.entitystore.EntityStoreSerializer}
 * class for table {@link com.speedment.runtime.config.Table} named
 * UserApplicationLog.
 * <p>
 * This file is safe to edit. It will not be overwritten by the code generator.
 * 
 * @author company
 */
public final class UserApplicationLogEntityStoreSerializerImpl extends GeneratedUserApplicationLogEntityStoreSerializerImpl {
    
    public UserApplicationLogEntityStoreSerializerImpl(LongFunction<ByteBuffer> bufferFinder, LongToIntFunction offsetFinder) {
        super(bufferFinder, offsetFinder);
    }
}