package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.OsObject;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BookingMovieResultRealmProxy extends org.snowcorp.app.model.BookingMovieResult
    implements RealmObjectProxy, BookingMovieResultRealmProxyInterface {

    static final class BookingMovieResultColumnInfo extends ColumnInfo {
        long idIndex;
        long titleIndex;
        long dateTimeIndex;

        BookingMovieResultColumnInfo(SharedRealm realm, Table table) {
            super(3);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.titleIndex = addColumnDetails(table, "title", RealmFieldType.STRING);
            this.dateTimeIndex = addColumnDetails(table, "dateTime", RealmFieldType.STRING);
        }

        BookingMovieResultColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BookingMovieResultColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BookingMovieResultColumnInfo src = (BookingMovieResultColumnInfo) rawSrc;
            final BookingMovieResultColumnInfo dst = (BookingMovieResultColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.titleIndex = src.titleIndex;
            dst.dateTimeIndex = src.dateTimeIndex;
        }
    }

    private BookingMovieResultColumnInfo columnInfo;
    private ProxyState<org.snowcorp.app.model.BookingMovieResult> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("title");
        fieldNames.add("dateTime");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    BookingMovieResultRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BookingMovieResultColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<org.snowcorp.app.model.BookingMovieResult>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.idIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(Integer value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$dateTime() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dateTimeIndex);
    }

    @Override
    public void realmSet$dateTime(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dateTimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dateTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dateTimeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dateTimeIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("BookingMovieResult")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("BookingMovieResult");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("dateTime", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("BookingMovieResult");
    }

    public static BookingMovieResultColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_BookingMovieResult")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'BookingMovieResult' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_BookingMovieResult");
        final long columnCount = table.getColumnCount();
        if (columnCount != 3) {
            if (columnCount < 3) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 3 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 3 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final BookingMovieResultColumnInfo columnInfo = new BookingMovieResultColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            }
        }

        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("title")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("title") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'title' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.titleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'title' is required. Either set @Required to field 'title' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("dateTime")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dateTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("dateTime") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'dateTime' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.dateTimeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dateTime' is required. Either set @Required to field 'dateTime' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_BookingMovieResult";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static org.snowcorp.app.model.BookingMovieResult createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        org.snowcorp.app.model.BookingMovieResult obj = null;
        if (update) {
            Table table = realm.getTable(org.snowcorp.app.model.BookingMovieResult.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.BookingMovieResult.class), false, Collections.<String> emptyList());
                    obj = new io.realm.BookingMovieResultRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.BookingMovieResultRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.BookingMovieResult.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.BookingMovieResultRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.BookingMovieResult.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((BookingMovieResultRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((BookingMovieResultRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("dateTime")) {
            if (json.isNull("dateTime")) {
                ((BookingMovieResultRealmProxyInterface) obj).realmSet$dateTime(null);
            } else {
                ((BookingMovieResultRealmProxyInterface) obj).realmSet$dateTime((String) json.getString("dateTime"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static org.snowcorp.app.model.BookingMovieResult createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        org.snowcorp.app.model.BookingMovieResult obj = new org.snowcorp.app.model.BookingMovieResult();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BookingMovieResultRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((BookingMovieResultRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BookingMovieResultRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((BookingMovieResultRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("dateTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BookingMovieResultRealmProxyInterface) obj).realmSet$dateTime(null);
                } else {
                    ((BookingMovieResultRealmProxyInterface) obj).realmSet$dateTime((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static org.snowcorp.app.model.BookingMovieResult copyOrUpdate(Realm realm, org.snowcorp.app.model.BookingMovieResult object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.BookingMovieResult) cachedRealmObject;
        } else {
            org.snowcorp.app.model.BookingMovieResult realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(org.snowcorp.app.model.BookingMovieResult.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((BookingMovieResultRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.BookingMovieResult.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.BookingMovieResultRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static org.snowcorp.app.model.BookingMovieResult copy(Realm realm, org.snowcorp.app.model.BookingMovieResult newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.BookingMovieResult) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            org.snowcorp.app.model.BookingMovieResult realmObject = realm.createObjectInternal(org.snowcorp.app.model.BookingMovieResult.class, ((BookingMovieResultRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((BookingMovieResultRealmProxyInterface) realmObject).realmSet$title(((BookingMovieResultRealmProxyInterface) newObject).realmGet$title());
            ((BookingMovieResultRealmProxyInterface) realmObject).realmSet$dateTime(((BookingMovieResultRealmProxyInterface) newObject).realmGet$dateTime());
            return realmObject;
        }
    }

    public static long insert(Realm realm, org.snowcorp.app.model.BookingMovieResult object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.BookingMovieResult.class);
        long tableNativePtr = table.getNativePtr();
        BookingMovieResultColumnInfo columnInfo = (BookingMovieResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.BookingMovieResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((BookingMovieResultRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((BookingMovieResultRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((BookingMovieResultRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$title = ((BookingMovieResultRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$dateTime = ((BookingMovieResultRealmProxyInterface)object).realmGet$dateTime();
        if (realmGet$dateTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.BookingMovieResult.class);
        long tableNativePtr = table.getNativePtr();
        BookingMovieResultColumnInfo columnInfo = (BookingMovieResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.BookingMovieResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.BookingMovieResult object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.BookingMovieResult) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((BookingMovieResultRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((BookingMovieResultRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((BookingMovieResultRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$title = ((BookingMovieResultRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                String realmGet$dateTime = ((BookingMovieResultRealmProxyInterface)object).realmGet$dateTime();
                if (realmGet$dateTime != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, org.snowcorp.app.model.BookingMovieResult object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.BookingMovieResult.class);
        long tableNativePtr = table.getNativePtr();
        BookingMovieResultColumnInfo columnInfo = (BookingMovieResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.BookingMovieResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((BookingMovieResultRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((BookingMovieResultRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((BookingMovieResultRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$title = ((BookingMovieResultRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$dateTime = ((BookingMovieResultRealmProxyInterface)object).realmGet$dateTime();
        if (realmGet$dateTime != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.BookingMovieResult.class);
        long tableNativePtr = table.getNativePtr();
        BookingMovieResultColumnInfo columnInfo = (BookingMovieResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.BookingMovieResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.BookingMovieResult object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.BookingMovieResult) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((BookingMovieResultRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((BookingMovieResultRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((BookingMovieResultRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                String realmGet$title = ((BookingMovieResultRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                String realmGet$dateTime = ((BookingMovieResultRealmProxyInterface)object).realmGet$dateTime();
                if (realmGet$dateTime != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, false);
                }
            }
        }
    }

    public static org.snowcorp.app.model.BookingMovieResult createDetachedCopy(org.snowcorp.app.model.BookingMovieResult realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        org.snowcorp.app.model.BookingMovieResult unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (org.snowcorp.app.model.BookingMovieResult)cachedObject.object;
            } else {
                unmanagedObject = (org.snowcorp.app.model.BookingMovieResult)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new org.snowcorp.app.model.BookingMovieResult();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((BookingMovieResultRealmProxyInterface) unmanagedObject).realmSet$id(((BookingMovieResultRealmProxyInterface) realmObject).realmGet$id());
        ((BookingMovieResultRealmProxyInterface) unmanagedObject).realmSet$title(((BookingMovieResultRealmProxyInterface) realmObject).realmGet$title());
        ((BookingMovieResultRealmProxyInterface) unmanagedObject).realmSet$dateTime(((BookingMovieResultRealmProxyInterface) realmObject).realmGet$dateTime());
        return unmanagedObject;
    }

    static org.snowcorp.app.model.BookingMovieResult update(Realm realm, org.snowcorp.app.model.BookingMovieResult realmObject, org.snowcorp.app.model.BookingMovieResult newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((BookingMovieResultRealmProxyInterface) realmObject).realmSet$title(((BookingMovieResultRealmProxyInterface) newObject).realmGet$title());
        ((BookingMovieResultRealmProxyInterface) realmObject).realmSet$dateTime(((BookingMovieResultRealmProxyInterface) newObject).realmGet$dateTime());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("BookingMovieResult = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dateTime:");
        stringBuilder.append(realmGet$dateTime() != null ? realmGet$dateTime() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingMovieResultRealmProxy aBookingMovieResult = (BookingMovieResultRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBookingMovieResult.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBookingMovieResult.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBookingMovieResult.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
