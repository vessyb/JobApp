package com.company.dbo.jobapplicationdatabase.dbo.jobpost;

import com.company.dbo.jobapplicationdatabase.dbo.jobpost.generated.GeneratedJobPostEntityStoreSerializerImpl;

import java.nio.ByteBuffer;
import java.util.function.LongFunction;
import java.util.function.LongToIntFunction;

/**
 * An {@link
 * com.speedment.enterprise.datastore.runtime.entitystore.EntityStoreSerializer}
 * class for table {@link com.speedment.runtime.config.Table} named JobPost.
 * <p>
 * This file is safe to edit. It will not be overwritten by the code generator.
 * 
 * @author company
 */
public final class JobPostEntityStoreSerializerImpl extends GeneratedJobPostEntityStoreSerializerImpl {
    
    public JobPostEntityStoreSerializerImpl(LongFunction<ByteBuffer> bufferFinder, LongToIntFunction offsetFinder) {
        super(bufferFinder, offsetFinder);
    }
}