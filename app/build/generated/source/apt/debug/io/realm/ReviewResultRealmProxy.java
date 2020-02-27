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

public class ReviewResultRealmProxy extends org.snowcorp.app.model.ReviewResult
    implements RealmObjectProxy, ReviewResultRealmProxyInterface {

    static final class ReviewResultColumnInfo extends ColumnInfo {
        long authorIndex;
        long contentIndex;
        long idIndex;
        long reviewIDIndex;
        long urlIndex;

        ReviewResultColumnInfo(SharedRealm realm, Table table) {
            super(5);
            this.authorIndex = addColumnDetails(table, "author", RealmFieldType.STRING);
            this.contentIndex = addColumnDetails(table, "content", RealmFieldType.STRING);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.STRING);
            this.reviewIDIndex = addColumnDetails(table, "reviewID", RealmFieldType.INTEGER);
            this.urlIndex = addColumnDetails(table, "url", RealmFieldType.STRING);
        }

        ReviewResultColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ReviewResultColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ReviewResultColumnInfo src = (ReviewResultColumnInfo) rawSrc;
            final ReviewResultColumnInfo dst = (ReviewResultColumnInfo) rawDst;
            dst.authorIndex = src.authorIndex;
            dst.contentIndex = src.contentIndex;
            dst.idIndex = src.idIndex;
            dst.reviewIDIndex = src.reviewIDIndex;
            dst.urlIndex = src.urlIndex;
        }
    }

    private ReviewResultColumnInfo columnInfo;
    private ProxyState<org.snowcorp.app.model.ReviewResult> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("author");
        fieldNames.add("content");
        fieldNames.add("id");
        fieldNames.add("reviewID");
        fieldNames.add("url");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ReviewResultRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ReviewResultColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<org.snowcorp.app.model.ReviewResult>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$author() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.authorIndex);
    }

    @Override
    public void realmSet$author(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.authorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.authorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.authorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.authorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$content() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentIndex);
    }

    @Override
    public void realmSet$content(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$reviewID() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.reviewIDIndex);
    }

    @Override
    public void realmSet$reviewID(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'reviewID' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlIndex);
    }

    @Override
    public void realmSet$url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.urlIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("ReviewResult")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ReviewResult");
            realmObjectSchema.add("author", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("content", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("reviewID", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("ReviewResult");
    }

    public static ReviewResultColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_ReviewResult")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ReviewResult' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_ReviewResult");
        final long columnCount = table.getColumnCount();
        if (columnCount != 5) {
            if (columnCount < 5) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final ReviewResultColumnInfo columnInfo = new ReviewResultColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'reviewID' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.reviewIDIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field reviewID");
            }
        }

        if (!columnTypes.containsKey("author")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'author' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("author") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'author' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.authorIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'author' is required. Either set @Required to field 'author' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("content")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'content' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("content") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'content' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.contentIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'content' is required. Either set @Required to field 'content' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'id' is required. Either set @Required to field 'id' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("reviewID")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'reviewID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("reviewID") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'reviewID' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.reviewIDIndex) && table.findFirstNull(columnInfo.reviewIDIndex) != Table.NO_MATCH) {
            throw new IllegalStateException("Cannot migrate an object with null value in field 'reviewID'. Either maintain the same type for primary key field 'reviewID', or remove the object with null value before migration.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("reviewID"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'reviewID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("url")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'url' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("url") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'url' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.urlIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'url' is required. Either set @Required to field 'url' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_ReviewResult";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static org.snowcorp.app.model.ReviewResult createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        org.snowcorp.app.model.ReviewResult obj = null;
        if (update) {
            Table table = realm.getTable(org.snowcorp.app.model.ReviewResult.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("reviewID")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("reviewID"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.ReviewResult.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ReviewResultRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("reviewID")) {
                if (json.isNull("reviewID")) {
                    obj = (io.realm.ReviewResultRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.ReviewResult.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ReviewResultRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.ReviewResult.class, json.getLong("reviewID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'reviewID'.");
            }
        }
        if (json.has("author")) {
            if (json.isNull("author")) {
                ((ReviewResultRealmProxyInterface) obj).realmSet$author(null);
            } else {
                ((ReviewResultRealmProxyInterface) obj).realmSet$author((String) json.getString("author"));
            }
        }
        if (json.has("content")) {
            if (json.isNull("content")) {
                ((ReviewResultRealmProxyInterface) obj).realmSet$content(null);
            } else {
                ((ReviewResultRealmProxyInterface) obj).realmSet$content((String) json.getString("content"));
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                ((ReviewResultRealmProxyInterface) obj).realmSet$id(null);
            } else {
                ((ReviewResultRealmProxyInterface) obj).realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("url")) {
            if (json.isNull("url")) {
                ((ReviewResultRealmProxyInterface) obj).realmSet$url(null);
            } else {
                ((ReviewResultRealmProxyInterface) obj).realmSet$url((String) json.getString("url"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static org.snowcorp.app.model.ReviewResult createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        org.snowcorp.app.model.ReviewResult obj = new org.snowcorp.app.model.ReviewResult();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("author")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ReviewResultRealmProxyInterface) obj).realmSet$author(null);
                } else {
                    ((ReviewResultRealmProxyInterface) obj).realmSet$author((String) reader.nextString());
                }
            } else if (name.equals("content")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ReviewResultRealmProxyInterface) obj).realmSet$content(null);
                } else {
                    ((ReviewResultRealmProxyInterface) obj).realmSet$content((String) reader.nextString());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ReviewResultRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((ReviewResultRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
            } else if (name.equals("reviewID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'reviewID' to null.");
                } else {
                    ((ReviewResultRealmProxyInterface) obj).realmSet$reviewID((long) reader.nextLong());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("url")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ReviewResultRealmProxyInterface) obj).realmSet$url(null);
                } else {
                    ((ReviewResultRealmProxyInterface) obj).realmSet$url((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'reviewID'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static org.snowcorp.app.model.ReviewResult copyOrUpdate(Realm realm, org.snowcorp.app.model.ReviewResult object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.ReviewResult) cachedRealmObject;
        } else {
            org.snowcorp.app.model.ReviewResult realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(org.snowcorp.app.model.ReviewResult.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((ReviewResultRealmProxyInterface) object).realmGet$reviewID());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.ReviewResult.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ReviewResultRealmProxy();
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

    public static org.snowcorp.app.model.ReviewResult copy(Realm realm, org.snowcorp.app.model.ReviewResult newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.ReviewResult) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            org.snowcorp.app.model.ReviewResult realmObject = realm.createObjectInternal(org.snowcorp.app.model.ReviewResult.class, ((ReviewResultRealmProxyInterface) newObject).realmGet$reviewID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ReviewResultRealmProxyInterface) realmObject).realmSet$author(((ReviewResultRealmProxyInterface) newObject).realmGet$author());
            ((ReviewResultRealmProxyInterface) realmObject).realmSet$content(((ReviewResultRealmProxyInterface) newObject).realmGet$content());
            ((ReviewResultRealmProxyInterface) realmObject).realmSet$id(((ReviewResultRealmProxyInterface) newObject).realmGet$id());
            ((ReviewResultRealmProxyInterface) realmObject).realmSet$url(((ReviewResultRealmProxyInterface) newObject).realmGet$url());
            return realmObject;
        }
    }

    public static long insert(Realm realm, org.snowcorp.app.model.ReviewResult object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.ReviewResult.class);
        long tableNativePtr = table.getNativePtr();
        ReviewResultColumnInfo columnInfo = (ReviewResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.ReviewResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((ReviewResultRealmProxyInterface) object).realmGet$reviewID();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReviewResultRealmProxyInterface) object).realmGet$reviewID());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ReviewResultRealmProxyInterface) object).realmGet$reviewID());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$author = ((ReviewResultRealmProxyInterface)object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        }
        String realmGet$content = ((ReviewResultRealmProxyInterface)object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        }
        String realmGet$id = ((ReviewResultRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$url = ((ReviewResultRealmProxyInterface)object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.ReviewResult.class);
        long tableNativePtr = table.getNativePtr();
        ReviewResultColumnInfo columnInfo = (ReviewResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.ReviewResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.ReviewResult object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.ReviewResult) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((ReviewResultRealmProxyInterface) object).realmGet$reviewID();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReviewResultRealmProxyInterface) object).realmGet$reviewID());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ReviewResultRealmProxyInterface) object).realmGet$reviewID());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$author = ((ReviewResultRealmProxyInterface)object).realmGet$author();
                if (realmGet$author != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
                }
                String realmGet$content = ((ReviewResultRealmProxyInterface)object).realmGet$content();
                if (realmGet$content != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
                }
                String realmGet$id = ((ReviewResultRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                }
                String realmGet$url = ((ReviewResultRealmProxyInterface)object).realmGet$url();
                if (realmGet$url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, org.snowcorp.app.model.ReviewResult object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.ReviewResult.class);
        long tableNativePtr = table.getNativePtr();
        ReviewResultColumnInfo columnInfo = (ReviewResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.ReviewResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((ReviewResultRealmProxyInterface) object).realmGet$reviewID();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReviewResultRealmProxyInterface) object).realmGet$reviewID());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ReviewResultRealmProxyInterface) object).realmGet$reviewID());
        }
        cache.put(object, rowIndex);
        String realmGet$author = ((ReviewResultRealmProxyInterface)object).realmGet$author();
        if (realmGet$author != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
        }
        String realmGet$content = ((ReviewResultRealmProxyInterface)object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
        }
        String realmGet$id = ((ReviewResultRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$url = ((ReviewResultRealmProxyInterface)object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.ReviewResult.class);
        long tableNativePtr = table.getNativePtr();
        ReviewResultColumnInfo columnInfo = (ReviewResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.ReviewResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.ReviewResult object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.ReviewResult) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((ReviewResultRealmProxyInterface) object).realmGet$reviewID();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReviewResultRealmProxyInterface) object).realmGet$reviewID());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ReviewResultRealmProxyInterface) object).realmGet$reviewID());
                }
                cache.put(object, rowIndex);
                String realmGet$author = ((ReviewResultRealmProxyInterface)object).realmGet$author();
                if (realmGet$author != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.authorIndex, rowIndex, realmGet$author, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.authorIndex, rowIndex, false);
                }
                String realmGet$content = ((ReviewResultRealmProxyInterface)object).realmGet$content();
                if (realmGet$content != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
                }
                String realmGet$id = ((ReviewResultRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
                }
                String realmGet$url = ((ReviewResultRealmProxyInterface)object).realmGet$url();
                if (realmGet$url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
                }
            }
        }
    }

    public static org.snowcorp.app.model.ReviewResult createDetachedCopy(org.snowcorp.app.model.ReviewResult realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        org.snowcorp.app.model.ReviewResult unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (org.snowcorp.app.model.ReviewResult)cachedObject.object;
            } else {
                unmanagedObject = (org.snowcorp.app.model.ReviewResult)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new org.snowcorp.app.model.ReviewResult();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ReviewResultRealmProxyInterface) unmanagedObject).realmSet$author(((ReviewResultRealmProxyInterface) realmObject).realmGet$author());
        ((ReviewResultRealmProxyInterface) unmanagedObject).realmSet$content(((ReviewResultRealmProxyInterface) realmObject).realmGet$content());
        ((ReviewResultRealmProxyInterface) unmanagedObject).realmSet$id(((ReviewResultRealmProxyInterface) realmObject).realmGet$id());
        ((ReviewResultRealmProxyInterface) unmanagedObject).realmSet$reviewID(((ReviewResultRealmProxyInterface) realmObject).realmGet$reviewID());
        ((ReviewResultRealmProxyInterface) unmanagedObject).realmSet$url(((ReviewResultRealmProxyInterface) realmObject).realmGet$url());
        return unmanagedObject;
    }

    static org.snowcorp.app.model.ReviewResult update(Realm realm, org.snowcorp.app.model.ReviewResult realmObject, org.snowcorp.app.model.ReviewResult newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ReviewResultRealmProxyInterface) realmObject).realmSet$author(((ReviewResultRealmProxyInterface) newObject).realmGet$author());
        ((ReviewResultRealmProxyInterface) realmObject).realmSet$content(((ReviewResultRealmProxyInterface) newObject).realmGet$content());
        ((ReviewResultRealmProxyInterface) realmObject).realmSet$id(((ReviewResultRealmProxyInterface) newObject).realmGet$id());
        ((ReviewResultRealmProxyInterface) realmObject).realmSet$url(((ReviewResultRealmProxyInterface) newObject).realmGet$url());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ReviewResult = proxy[");
        stringBuilder.append("{author:");
        stringBuilder.append(realmGet$author() != null ? realmGet$author() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{content:");
        stringBuilder.append(realmGet$content() != null ? realmGet$content() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reviewID:");
        stringBuilder.append(realmGet$reviewID());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{url:");
        stringBuilder.append(realmGet$url() != null ? realmGet$url() : "null");
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
        ReviewResultRealmProxy aReviewResult = (ReviewResultRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aReviewResult.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aReviewResult.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aReviewResult.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
