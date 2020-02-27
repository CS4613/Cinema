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

public class SessionRealmProxy extends org.snowcorp.app.model.Session
    implements RealmObjectProxy, SessionRealmProxyInterface {

    static final class SessionColumnInfo extends ColumnInfo {
        long successIndex;
        long guestSessionIdIndex;
        long expiresAtIndex;

        SessionColumnInfo(SharedRealm realm, Table table) {
            super(3);
            this.successIndex = addColumnDetails(table, "success", RealmFieldType.BOOLEAN);
            this.guestSessionIdIndex = addColumnDetails(table, "guestSessionId", RealmFieldType.STRING);
            this.expiresAtIndex = addColumnDetails(table, "expiresAt", RealmFieldType.STRING);
        }

        SessionColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new SessionColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final SessionColumnInfo src = (SessionColumnInfo) rawSrc;
            final SessionColumnInfo dst = (SessionColumnInfo) rawDst;
            dst.successIndex = src.successIndex;
            dst.guestSessionIdIndex = src.guestSessionIdIndex;
            dst.expiresAtIndex = src.expiresAtIndex;
        }
    }

    private SessionColumnInfo columnInfo;
    private ProxyState<org.snowcorp.app.model.Session> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("success");
        fieldNames.add("guestSessionId");
        fieldNames.add("expiresAt");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    SessionRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (SessionColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<org.snowcorp.app.model.Session>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Boolean realmGet$success() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.successIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.successIndex);
    }

    @Override
    public void realmSet$success(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.successIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.successIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.successIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.successIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$guestSessionId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.guestSessionIdIndex);
    }

    @Override
    public void realmSet$guestSessionId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.guestSessionIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.guestSessionIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.guestSessionIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.guestSessionIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$expiresAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.expiresAtIndex);
    }

    @Override
    public void realmSet$expiresAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.expiresAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.expiresAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.expiresAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.expiresAtIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Session")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Session");
            realmObjectSchema.add("success", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("guestSessionId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("expiresAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Session");
    }

    public static SessionColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Session")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Session' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Session");
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

        final SessionColumnInfo columnInfo = new SessionColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("success")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'success' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("success") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'success' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.successIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'success' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'success' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("guestSessionId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'guestSessionId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("guestSessionId") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'guestSessionId' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.guestSessionIdIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'guestSessionId' is required. Either set @Required to field 'guestSessionId' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("expiresAt")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'expiresAt' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("expiresAt") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'expiresAt' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.expiresAtIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'expiresAt' is required. Either set @Required to field 'expiresAt' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Session";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static org.snowcorp.app.model.Session createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        org.snowcorp.app.model.Session obj = realm.createObjectInternal(org.snowcorp.app.model.Session.class, true, excludeFields);
        if (json.has("success")) {
            if (json.isNull("success")) {
                ((SessionRealmProxyInterface) obj).realmSet$success(null);
            } else {
                ((SessionRealmProxyInterface) obj).realmSet$success((boolean) json.getBoolean("success"));
            }
        }
        if (json.has("guestSessionId")) {
            if (json.isNull("guestSessionId")) {
                ((SessionRealmProxyInterface) obj).realmSet$guestSessionId(null);
            } else {
                ((SessionRealmProxyInterface) obj).realmSet$guestSessionId((String) json.getString("guestSessionId"));
            }
        }
        if (json.has("expiresAt")) {
            if (json.isNull("expiresAt")) {
                ((SessionRealmProxyInterface) obj).realmSet$expiresAt(null);
            } else {
                ((SessionRealmProxyInterface) obj).realmSet$expiresAt((String) json.getString("expiresAt"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static org.snowcorp.app.model.Session createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        org.snowcorp.app.model.Session obj = new org.snowcorp.app.model.Session();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("success")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SessionRealmProxyInterface) obj).realmSet$success(null);
                } else {
                    ((SessionRealmProxyInterface) obj).realmSet$success((boolean) reader.nextBoolean());
                }
            } else if (name.equals("guestSessionId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SessionRealmProxyInterface) obj).realmSet$guestSessionId(null);
                } else {
                    ((SessionRealmProxyInterface) obj).realmSet$guestSessionId((String) reader.nextString());
                }
            } else if (name.equals("expiresAt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((SessionRealmProxyInterface) obj).realmSet$expiresAt(null);
                } else {
                    ((SessionRealmProxyInterface) obj).realmSet$expiresAt((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static org.snowcorp.app.model.Session copyOrUpdate(Realm realm, org.snowcorp.app.model.Session object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.Session) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static org.snowcorp.app.model.Session copy(Realm realm, org.snowcorp.app.model.Session newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.Session) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            org.snowcorp.app.model.Session realmObject = realm.createObjectInternal(org.snowcorp.app.model.Session.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((SessionRealmProxyInterface) realmObject).realmSet$success(((SessionRealmProxyInterface) newObject).realmGet$success());
            ((SessionRealmProxyInterface) realmObject).realmSet$guestSessionId(((SessionRealmProxyInterface) newObject).realmGet$guestSessionId());
            ((SessionRealmProxyInterface) realmObject).realmSet$expiresAt(((SessionRealmProxyInterface) newObject).realmGet$expiresAt());
            return realmObject;
        }
    }

    public static long insert(Realm realm, org.snowcorp.app.model.Session object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.Session.class);
        long tableNativePtr = table.getNativePtr();
        SessionColumnInfo columnInfo = (SessionColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Session.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Boolean realmGet$success = ((SessionRealmProxyInterface)object).realmGet$success();
        if (realmGet$success != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.successIndex, rowIndex, realmGet$success, false);
        }
        String realmGet$guestSessionId = ((SessionRealmProxyInterface)object).realmGet$guestSessionId();
        if (realmGet$guestSessionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.guestSessionIdIndex, rowIndex, realmGet$guestSessionId, false);
        }
        String realmGet$expiresAt = ((SessionRealmProxyInterface)object).realmGet$expiresAt();
        if (realmGet$expiresAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.expiresAtIndex, rowIndex, realmGet$expiresAt, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.Session.class);
        long tableNativePtr = table.getNativePtr();
        SessionColumnInfo columnInfo = (SessionColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Session.class);
        org.snowcorp.app.model.Session object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.Session) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Boolean realmGet$success = ((SessionRealmProxyInterface)object).realmGet$success();
                if (realmGet$success != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.successIndex, rowIndex, realmGet$success, false);
                }
                String realmGet$guestSessionId = ((SessionRealmProxyInterface)object).realmGet$guestSessionId();
                if (realmGet$guestSessionId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.guestSessionIdIndex, rowIndex, realmGet$guestSessionId, false);
                }
                String realmGet$expiresAt = ((SessionRealmProxyInterface)object).realmGet$expiresAt();
                if (realmGet$expiresAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.expiresAtIndex, rowIndex, realmGet$expiresAt, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, org.snowcorp.app.model.Session object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.Session.class);
        long tableNativePtr = table.getNativePtr();
        SessionColumnInfo columnInfo = (SessionColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Session.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Boolean realmGet$success = ((SessionRealmProxyInterface)object).realmGet$success();
        if (realmGet$success != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.successIndex, rowIndex, realmGet$success, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.successIndex, rowIndex, false);
        }
        String realmGet$guestSessionId = ((SessionRealmProxyInterface)object).realmGet$guestSessionId();
        if (realmGet$guestSessionId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.guestSessionIdIndex, rowIndex, realmGet$guestSessionId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.guestSessionIdIndex, rowIndex, false);
        }
        String realmGet$expiresAt = ((SessionRealmProxyInterface)object).realmGet$expiresAt();
        if (realmGet$expiresAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.expiresAtIndex, rowIndex, realmGet$expiresAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.expiresAtIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.Session.class);
        long tableNativePtr = table.getNativePtr();
        SessionColumnInfo columnInfo = (SessionColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Session.class);
        org.snowcorp.app.model.Session object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.Session) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Boolean realmGet$success = ((SessionRealmProxyInterface)object).realmGet$success();
                if (realmGet$success != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.successIndex, rowIndex, realmGet$success, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.successIndex, rowIndex, false);
                }
                String realmGet$guestSessionId = ((SessionRealmProxyInterface)object).realmGet$guestSessionId();
                if (realmGet$guestSessionId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.guestSessionIdIndex, rowIndex, realmGet$guestSessionId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.guestSessionIdIndex, rowIndex, false);
                }
                String realmGet$expiresAt = ((SessionRealmProxyInterface)object).realmGet$expiresAt();
                if (realmGet$expiresAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.expiresAtIndex, rowIndex, realmGet$expiresAt, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.expiresAtIndex, rowIndex, false);
                }
            }
        }
    }

    public static org.snowcorp.app.model.Session createDetachedCopy(org.snowcorp.app.model.Session realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        org.snowcorp.app.model.Session unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (org.snowcorp.app.model.Session)cachedObject.object;
            } else {
                unmanagedObject = (org.snowcorp.app.model.Session)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new org.snowcorp.app.model.Session();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((SessionRealmProxyInterface) unmanagedObject).realmSet$success(((SessionRealmProxyInterface) realmObject).realmGet$success());
        ((SessionRealmProxyInterface) unmanagedObject).realmSet$guestSessionId(((SessionRealmProxyInterface) realmObject).realmGet$guestSessionId());
        ((SessionRealmProxyInterface) unmanagedObject).realmSet$expiresAt(((SessionRealmProxyInterface) realmObject).realmGet$expiresAt());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Session = proxy[");
        stringBuilder.append("{success:");
        stringBuilder.append(realmGet$success() != null ? realmGet$success() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{guestSessionId:");
        stringBuilder.append(realmGet$guestSessionId() != null ? realmGet$guestSessionId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{expiresAt:");
        stringBuilder.append(realmGet$expiresAt() != null ? realmGet$expiresAt() : "null");
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
        SessionRealmProxy aSession = (SessionRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aSession.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aSession.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aSession.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
