package com.company.dbo.jobapplicationdatabase.dbo.usertype.generated;

import com.company.dbo.jobapplicationdatabase.dbo.usertype.UserType;
import com.company.dbo.jobapplicationdatabase.dbo.usertype.UserTypeImpl;
import com.speedment.common.annotation.GeneratedCode;
import com.speedment.common.function.BiLongToIntFunction;
import com.speedment.common.function.LongToBooleanFunction;
import com.speedment.common.function.LongToByteFunction;
import com.speedment.common.function.LongToCharFunction;
import com.speedment.common.function.LongToFloatFunction;
import com.speedment.common.function.LongToShortFunction;
import com.speedment.enterprise.common.bytebuffercommon.ByteBufferUtil;
import com.speedment.enterprise.datastore.runtime.DataStoreHolder;
import com.speedment.enterprise.datastore.runtime.entitystore.EntityStoreSerializer;
import com.speedment.enterprise.datastore.runtime.entitystore.function.EntityStoreComparator;
import com.speedment.enterprise.datastore.runtime.entitystore.function.EntityStoreCompareTo;
import com.speedment.enterprise.datastore.runtime.entitystore.function.EntityStorePredicate;
import com.speedment.enterprise.datastore.runtime.internal.throwable.Utf8Exception;
import com.speedment.enterprise.datastore.runtime.throwable.DeserializationException;
import com.speedment.enterprise.datastore.runtime.util.SerializerUtil;
import com.speedment.enterprise.datastore.runtime.util.Utf8Util;
import com.speedment.runtime.config.identifier.ColumnIdentifier;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;

/**
 * Serializes and deserializes instances of UserType.
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedUserTypeEntityStoreSerializerImpl implements EntityStoreSerializer<UserType> {
    
    private final LongFunction<ByteBuffer> bufferFinder;
    private final LongToIntFunction offsetFinder;
    private final static int FIELD_ID = 0;
    private final static int ENDPOS_TYPE = 4;
    private final static int VARSIZE_BEGINS = 8;
    
    protected GeneratedUserTypeEntityStoreSerializerImpl(final LongFunction<ByteBuffer> bufferFinder, final LongToIntFunction offsetFinder) {
        this.bufferFinder = requireNonNull(bufferFinder);
        this.offsetFinder = requireNonNull(offsetFinder);
    }
    
    @Override
    public BiConsumer<ByteBuffer, UserType> serializer() {
        return (buffer, entity) -> {
            int varSizePos = 0;
            buffer.putInt(FIELD_ID, entity.getId());
            varSizePos += ByteBufferUtil.putArrayAbsolute(buffer, VARSIZE_BEGINS + varSizePos, entity.getType().getBytes());
            buffer.putInt(ENDPOS_TYPE, varSizePos);
            buffer.position(0);
            buffer.limit(VARSIZE_BEGINS + varSizePos);
        };
    }
    
    @Override
    public LongConsumer decorator(DataStoreHolder holder) {
        return DO_NOTHING;
    }
    
    @Override
    public LongFunction<UserType> deserializer() {
        return ref -> {
            final ByteBuffer buffer = bufferFinder.apply(ref);
            final int offset = offsetFinder.applyAsInt(ref);
            final UserType entity = new UserTypeImpl();
            entity.setId(buffer.getInt(offset + FIELD_ID));
            try {
                entity.setType(Utf8Util.deserialize(buffer,
                    offset + VARSIZE_BEGINS + 0,
                    offset + VARSIZE_BEGINS + buffer.getInt(offset + ENDPOS_TYPE)
                ));
            } catch (final Utf8Exception ex) {
                final LongToIntFunction sizeOf = sizeOf();
                throw new DeserializationException(buffer, offset, sizeOf.applyAsInt(ref), ex);
            }
            return entity;
        };
    }
    
    @Override
    public Class<?> deserializedType(final ColumnIdentifier<UserType> colId) {
        if (colId instanceof UserType.Identifier) {
            final UserType.Identifier _id = (UserType.Identifier) colId;
            switch (_id) {
                case ID   : return int.class;
                case TYPE : return String.class;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "id"   : return int.class;
                case "type" : return String.class;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public <FK_ENTITY> LongUnaryOperator finder(final ColumnIdentifier<UserType> colId, final ColumnIdentifier<FK_ENTITY> fkColId) {
        return finder(singletonList(colId), singletonList(fkColId));
    }
    
    @Override
    public <FK_ENTITY> LongUnaryOperator finder(final List<ColumnIdentifier<UserType>> cols, final List<ColumnIdentifier<FK_ENTITY>> fkCols) {
        throw new UnsupportedOperationException("UserType has no foreign references.");
    }
    
    @Override
    public LongUnaryOperator finder(final String fkName) {
        throw new UnsupportedOperationException("UserType has no foreign references.");
    }
    
    @Override
    public LongPredicate isNull(final ColumnIdentifier<UserType> colId) {
        if (colId instanceof UserType.Identifier) {
            final UserType.Identifier _id = (UserType.Identifier) colId;
            switch (_id) {
                case ID   : 
                case TYPE : return ALWAYS_FALSE;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "id"   : 
                case "type" : return ALWAYS_FALSE;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongPredicate isPresent(final ColumnIdentifier<UserType> colId) {
        if (colId instanceof UserType.Identifier) {
            final UserType.Identifier _id = (UserType.Identifier) colId;
            switch (_id) {
                case ID   : 
                case TYPE : return ALWAYS_TRUE;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "id"   : 
                case "type" : return ALWAYS_TRUE;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongToByteFunction byteDeserializer(final ColumnIdentifier<UserType> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type byte.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToShortFunction shortDeserializer(final ColumnIdentifier<UserType> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type short.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction intDeserializer(final ColumnIdentifier<UserType> colId) {
        if ("id".equals(colId.getColumnId())) {
            return ref -> bufferFinder.apply(ref).getInt(offsetFinder.applyAsInt(ref) + FIELD_ID);
        }
        
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type int.", colId.getColumnId())
        );
    }
    
    @Override
    public LongUnaryOperator longDeserializer(final ColumnIdentifier<UserType> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type long.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToFloatFunction floatDeserializer(final ColumnIdentifier<UserType> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type float.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToDoubleFunction doubleDeserializer(final ColumnIdentifier<UserType> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type double.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToCharFunction charDeserializer(final ColumnIdentifier<UserType> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type char.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToBooleanFunction booleanDeserializer(final ColumnIdentifier<UserType> colId) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type boolean.", colId.getColumnId())
        );
    }
    
    @Override
    public LongFunction<?> objectDeserializer(final ColumnIdentifier<UserType> colId) {
        if ("type".equals(colId.getColumnId())) {
            return ref -> {
                final ByteBuffer buffer = bufferFinder.apply(ref);
                final int offset = offsetFinder.applyAsInt(ref);
                try {
                    return Utf8Util.deserialize(buffer,
                        offset + VARSIZE_BEGINS + 0,
                        offset + VARSIZE_BEGINS + buffer.getInt(offset + ENDPOS_TYPE)
                    );
                } catch (final Utf8Exception ex) {
                    final LongToIntFunction sizeOf = sizeOf();
                    throw new DeserializationException(buffer, offset, sizeOf.applyAsInt(ref), ex);
                }
            };
        }
        
        throw new UnsupportedOperationException(
            String.format("Unknown column name '%s'.", colId.getColumnId())
        );
    }
    
    @Override
    public BiLongToIntFunction comparator(final ColumnIdentifier<UserType> colId) {
        if (colId instanceof UserType.Identifier) {
            final UserType.Identifier _id = (UserType.Identifier) colId;
            switch (_id) {
                case ID   : return (aRef, bRef) -> Integer.compare(
                    bufferFinder.apply(aRef).getInt(offsetFinder.applyAsInt(aRef) + FIELD_ID),
                    bufferFinder.apply(bRef).getInt(offsetFinder.applyAsInt(bRef) + FIELD_ID)
                );
                case TYPE : return (aRef, bRef) -> {
                    final ByteBuffer aBuf = bufferFinder.apply(aRef);
                    final ByteBuffer bBuf = bufferFinder.apply(bRef);
                    final int aOffset = offsetFinder.applyAsInt(aRef);
                    final int bOffset = offsetFinder.applyAsInt(bRef);
                    final int aStarts = aOffset + VARSIZE_BEGINS + 0;
                    final int bStarts = bOffset + VARSIZE_BEGINS + 0;
                    final int aEnds   = aOffset + VARSIZE_BEGINS + aBuf.getInt(aOffset + ENDPOS_TYPE);
                    final int bEnds   = bOffset + VARSIZE_BEGINS + bBuf.getInt(bOffset + ENDPOS_TYPE);
                    return ByteBufferUtil.compare(
                        aBuf, aStarts, aEnds,
                        bBuf, bStarts, bEnds
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "id"   : return (aRef, bRef) -> Integer.compare(
                    bufferFinder.apply(aRef).getInt(offsetFinder.applyAsInt(aRef) + FIELD_ID),
                    bufferFinder.apply(bRef).getInt(offsetFinder.applyAsInt(bRef) + FIELD_ID)
                );
                case "type" : return (aRef, bRef) -> {
                    final ByteBuffer aBuf = bufferFinder.apply(aRef);
                    final ByteBuffer bBuf = bufferFinder.apply(bRef);
                    final int aOffset = offsetFinder.applyAsInt(aRef);
                    final int bOffset = offsetFinder.applyAsInt(bRef);
                    final int aStarts = aOffset + VARSIZE_BEGINS + 0;
                    final int bStarts = bOffset + VARSIZE_BEGINS + 0;
                    final int aEnds   = aOffset + VARSIZE_BEGINS + aBuf.getInt(aOffset + ENDPOS_TYPE);
                    final int bEnds   = bOffset + VARSIZE_BEGINS + bBuf.getInt(bOffset + ENDPOS_TYPE);
                    return ByteBufferUtil.compare(
                        aBuf, aStarts, aEnds,
                        bBuf, bStarts, bEnds
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public BiLongToIntFunction comparatorNullsLast(final ColumnIdentifier<UserType> colId) {
        if (colId instanceof UserType.Identifier) {
            final UserType.Identifier _id = (UserType.Identifier) colId;
            switch (_id) {
                case ID   : return (aRef, bRef) -> Integer.compare(
                    bufferFinder.apply(aRef).getInt(offsetFinder.applyAsInt(aRef) + FIELD_ID),
                    bufferFinder.apply(bRef).getInt(offsetFinder.applyAsInt(bRef) + FIELD_ID)
                );
                case TYPE : return (aRef, bRef) -> {
                    final ByteBuffer aBuf = bufferFinder.apply(aRef);
                    final ByteBuffer bBuf = bufferFinder.apply(bRef);
                    final int aOffset = offsetFinder.applyAsInt(aRef);
                    final int bOffset = offsetFinder.applyAsInt(bRef);
                    final int aStarts = aOffset + VARSIZE_BEGINS + 0;
                    final int bStarts = bOffset + VARSIZE_BEGINS + 0;
                    final int aEnds   = aOffset + VARSIZE_BEGINS + aBuf.getInt(aOffset + ENDPOS_TYPE);
                    final int bEnds   = bOffset + VARSIZE_BEGINS + bBuf.getInt(bOffset + ENDPOS_TYPE);
                    return ByteBufferUtil.compare(
                        aBuf, aStarts, aEnds,
                        bBuf, bStarts, bEnds
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "id"   : return (aRef, bRef) -> Integer.compare(
                    bufferFinder.apply(aRef).getInt(offsetFinder.applyAsInt(aRef) + FIELD_ID),
                    bufferFinder.apply(bRef).getInt(offsetFinder.applyAsInt(bRef) + FIELD_ID)
                );
                case "type" : return (aRef, bRef) -> {
                    final ByteBuffer aBuf = bufferFinder.apply(aRef);
                    final ByteBuffer bBuf = bufferFinder.apply(bRef);
                    final int aOffset = offsetFinder.applyAsInt(aRef);
                    final int bOffset = offsetFinder.applyAsInt(bRef);
                    final int aStarts = aOffset + VARSIZE_BEGINS + 0;
                    final int bStarts = bOffset + VARSIZE_BEGINS + 0;
                    final int aEnds   = aOffset + VARSIZE_BEGINS + aBuf.getInt(aOffset + ENDPOS_TYPE);
                    final int bEnds   = bOffset + VARSIZE_BEGINS + bBuf.getInt(bOffset + ENDPOS_TYPE);
                    return ByteBufferUtil.compare(
                        aBuf, aStarts, aEnds,
                        bBuf, bStarts, bEnds
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongToIntFunction compareToByte(final ColumnIdentifier<UserType> colId, final byte value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type byte.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToShort(final ColumnIdentifier<UserType> colId, final short value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type short.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToInt(final ColumnIdentifier<UserType> colId, final int value) {
        if ("id".equals(colId.getColumnId())) {
            {
                final int operand = value;
                return ref -> Integer.compare(
                    bufferFinder.apply(ref).getInt(offsetFinder.applyAsInt(ref) + FIELD_ID),
                    operand
                );
            }
        }
        
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type int.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToLong(final ColumnIdentifier<UserType> colId, final long value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type long.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToFloat(final ColumnIdentifier<UserType> colId, final float value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type float.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToDouble(final ColumnIdentifier<UserType> colId, final double value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type double.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToBoolean(final ColumnIdentifier<UserType> colId, final boolean value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type boolean.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToChar(final ColumnIdentifier<UserType> colId, final char value) {
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type char.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToObject(final ColumnIdentifier<UserType> colId, final Object value) {
        if ("type".equals(colId.getColumnId())) {
            {
                final ByteBuffer tempBuffer = ByteBuffer.wrap(((String) value).getBytes());
                final int tempSize = tempBuffer.capacity();
                return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int offset = offsetFinder.applyAsInt(ref);
                    return ByteBufferUtil.compare(buffer,
                        offset + VARSIZE_BEGINS + 0,
                        offset + VARSIZE_BEGINS + buffer.getInt(offset + ENDPOS_TYPE),
                        tempBuffer, 0, tempSize
                    );
                };
            }
        }
        
        throw new UnsupportedOperationException(
            String.format("The column '%s' is either unknown or not of type object.", colId.getColumnId())
        );
    }
    
    @Override
    public LongToIntFunction compareToNull(final ColumnIdentifier<UserType> colId) {
        if (colId instanceof UserType.Identifier) {
            final UserType.Identifier _id = (UserType.Identifier) colId;
            switch (_id) {
                case ID   : return ALWAYS_LESS;
                case TYPE : return ref -> bufferFinder.apply(ref).getInt(offsetFinder.applyAsInt(ref) + ENDPOS_TYPE) < 0 ? 0 : -1;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "id"   : return ALWAYS_LESS;
                case "type" : return ref -> bufferFinder.apply(ref).getInt(offsetFinder.applyAsInt(ref) + ENDPOS_TYPE) < 0 ? 0 : -1;
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongPredicate newPredicate(final ColumnIdentifier<UserType> colId, final EntityStorePredicate predicate) {
        if (colId instanceof UserType.Identifier) {
            final UserType.Identifier _id = (UserType.Identifier) colId;
            switch (_id) {
                case ID   : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_ID;
                    return predicate.test(buffer, begins, begins + Integer.BYTES);
                };
                case TYPE : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    return predicate.test(buffer,
                        rowOffset + VARSIZE_BEGINS,
                        rowOffset + VARSIZE_BEGINS + buffer.getInt(rowOffset + ENDPOS_TYPE)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "id"   : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_ID;
                    return predicate.test(buffer, begins, begins + Integer.BYTES);
                };
                case "type" : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    return predicate.test(buffer,
                        rowOffset + VARSIZE_BEGINS,
                        rowOffset + VARSIZE_BEGINS + buffer.getInt(rowOffset + ENDPOS_TYPE)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongToIntFunction newCompareTo(final ColumnIdentifier<UserType> colId, final EntityStoreCompareTo compareTo) {
        if (colId instanceof UserType.Identifier) {
            final UserType.Identifier _id = (UserType.Identifier) colId;
            switch (_id) {
                case ID   : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_ID;
                    return compareTo.compare(buffer, begins, begins + Integer.BYTES);
                };
                case TYPE : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    return compareTo.compare(buffer,
                        rowOffset + VARSIZE_BEGINS,
                        rowOffset + VARSIZE_BEGINS + buffer.getInt(rowOffset + ENDPOS_TYPE)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "id"   : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    final int begins = rowOffset + FIELD_ID;
                    return compareTo.compare(buffer, begins, begins + Integer.BYTES);
                };
                case "type" : return ref -> {
                    final ByteBuffer buffer = bufferFinder.apply(ref);
                    final int rowOffset = offsetFinder.applyAsInt(ref);
                    return compareTo.compare(buffer,
                        rowOffset + VARSIZE_BEGINS,
                        rowOffset + VARSIZE_BEGINS + buffer.getInt(rowOffset + ENDPOS_TYPE)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public BiLongToIntFunction newComparator(final ColumnIdentifier<UserType> colId, final EntityStoreComparator comparator) {
        if (colId instanceof UserType.Identifier) {
            final UserType.Identifier _id = (UserType.Identifier) colId;
            switch (_id) {
                case ID   : return (aRef, bRef) -> {
                    final ByteBuffer aBuffer = bufferFinder.apply(aRef);
                    final ByteBuffer bBuffer = bufferFinder.apply(bRef);
                    final int aRowOffset = offsetFinder.applyAsInt(aRef);
                    final int bRowOffset = offsetFinder.applyAsInt(bRef);
                    final int aBegins = aRowOffset + FIELD_ID;
                    final int bBegins = bRowOffset + FIELD_ID;
                    return comparator.compare(
                        aBuffer, aBegins, aBegins + Integer.BYTES,
                        bBuffer, bBegins, bBegins + Integer.BYTES
                    );
                };
                case TYPE : return (aRef, bRef) -> {
                    final ByteBuffer aBuffer = bufferFinder.apply(aRef);
                    final ByteBuffer bBuffer = bufferFinder.apply(bRef);
                    final int aRowOffset = offsetFinder.applyAsInt(aRef);
                    final int bRowOffset = offsetFinder.applyAsInt(bRef);
                    return comparator.compare(
                        aBuffer, aRowOffset + VARSIZE_BEGINS, aRowOffset + VARSIZE_BEGINS + aBuffer.getInt(aRowOffset + ENDPOS_TYPE), 
                        bBuffer, bRowOffset + VARSIZE_BEGINS, bRowOffset + VARSIZE_BEGINS + bBuffer.getInt(bRowOffset + ENDPOS_TYPE)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown enum constant '%s'.", _id)
                    );
                }
            }
        } else {
            final String _colName = colId.getColumnId();
            switch (_colName) {
                case "id"   : return (aRef, bRef) -> {
                    final ByteBuffer aBuffer = bufferFinder.apply(aRef);
                    final ByteBuffer bBuffer = bufferFinder.apply(bRef);
                    final int aRowOffset = offsetFinder.applyAsInt(aRef);
                    final int bRowOffset = offsetFinder.applyAsInt(bRef);
                    final int aBegins = aRowOffset + FIELD_ID;
                    final int bBegins = bRowOffset + FIELD_ID;
                    return comparator.compare(
                        aBuffer, aBegins, aBegins + Integer.BYTES,
                        bBuffer, bBegins, bBegins + Integer.BYTES
                    );
                };
                case "type" : return (aRef, bRef) -> {
                    final ByteBuffer aBuffer = bufferFinder.apply(aRef);
                    final ByteBuffer bBuffer = bufferFinder.apply(bRef);
                    final int aRowOffset = offsetFinder.applyAsInt(aRef);
                    final int bRowOffset = offsetFinder.applyAsInt(bRef);
                    return comparator.compare(
                        aBuffer, aRowOffset + VARSIZE_BEGINS, aRowOffset + VARSIZE_BEGINS + aBuffer.getInt(aRowOffset + ENDPOS_TYPE), 
                        bBuffer, bRowOffset + VARSIZE_BEGINS, bRowOffset + VARSIZE_BEGINS + bBuffer.getInt(bRowOffset + ENDPOS_TYPE)
                    );
                };
                default : {
                    throw new UnsupportedOperationException(
                        String.format("Unknown column name '%s'.", _colName)
                    );
                }
            }
        }
    }
    
    @Override
    public LongToIntFunction sizeOf() {
        return ref -> VARSIZE_BEGINS + Math.abs(bufferFinder.apply(ref).getInt(offsetFinder.applyAsInt(ref) + ENDPOS_TYPE));
    }
}