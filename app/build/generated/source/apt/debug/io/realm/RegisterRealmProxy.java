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

public class RegisterRealmProxy extends org.snowcorp.app.model.Register
    implements RealmObjectProxy, RegisterRealmProxyInterface {

    static final class RegisterColumnInfo extends ColumnInfo {
        long IDIndex;
        long NameIndex;
        long EmailIndex;
        long PasswordIndex;

        RegisterColumnInfo(SharedRealm realm, Table table) {
            super(4);
            this.IDIndex = addColumnDetails(table, "ID", RealmFieldType.INTEGER);
            this.NameIndex = addColumnDetails(table, "Name", RealmFieldType.STRING);
            this.EmailIndex = addColumnDetails(table, "Email", RealmFieldType.STRING);
            this.PasswordIndex = addColumnDetails(table, "Password", RealmFieldType.STRING);
        }

        RegisterColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RegisterColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RegisterColumnInfo src = (RegisterColumnInfo) rawSrc;
            final RegisterColumnInfo dst = (RegisterColumnInfo) rawDst;
            dst.IDIndex = src.IDIndex;
            dst.NameIndex = src.NameIndex;
            dst.EmailIndex = src.EmailIndex;
            dst.PasswordIndex = src.PasswordIndex;
        }
    }

    private RegisterColumnInfo columnInfo;
    private ProxyState<org.snowcorp.app.model.Register> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("ID");
        fieldNames.add("Name");
        fieldNames.add("Email");
        fieldNames.add("Password");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    RegisterRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RegisterColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<org.snowcorp.app.model.Register>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$ID() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.IDIndex);
    }

    @Override
    public void realmSet$ID(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'ID' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.NameIndex);
    }

    @Override
    public void realmSet$Name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.NameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.NameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.NameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.NameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.EmailIndex);
    }

    @Override
    public void realmSet$Email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.EmailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.EmailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.EmailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.EmailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$Password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.PasswordIndex);
    }

    @Override
    public void realmSet$Password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.PasswordIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.PasswordIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.PasswordIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.PasswordIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Register")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Register");
            realmObjectSchema.add("ID", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("Name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("Email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("Password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Register");
    }

    public static RegisterColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Register")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Register' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Register");
        final long columnCount = table.getColumnCount();
        if (columnCount != 4) {
            if (columnCount < 4) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 4 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 4 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final RegisterColumnInfo columnInfo = new RegisterColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'ID' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.IDIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field ID");
            }
        }

        if (!columnTypes.containsKey("ID")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'ID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("ID") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'ID' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.IDIndex) && table.findFirstNull(columnInfo.IDIndex) != Table.NO_MATCH) {
            throw new IllegalStateException("Cannot migrate an object with null value in field 'ID'. Either maintain the same type for primary key field 'ID', or remove the object with null value before migration.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("ID"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'ID' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("Name")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("Name") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'Name' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.NameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'Name' is required. Either set @Required to field 'Name' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("Email")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Email' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("Email") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'Email' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.EmailIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'Email' is required. Either set @Required to field 'Email' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("Password")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'Password' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("Password") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'Password' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.PasswordIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'Password' is required. Either set @Required to field 'Password' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Register";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static org.snowcorp.app.model.Register createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        org.snowcorp.app.model.Register obj = null;
        if (update) {
            Table table = realm.getTable(org.snowcorp.app.model.Register.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("ID")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("ID"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.Register.class), false, Collections.<String> emptyList());
                    obj = new io.realm.RegisterRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("ID")) {
                if (json.isNull("ID")) {
                    obj = (io.realm.RegisterRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.Register.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.RegisterRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.Register.class, json.getInt("ID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'ID'.");
            }
        }
        if (json.has("Name")) {
            if (json.isNull("Name")) {
                ((RegisterRealmProxyInterface) obj).realmSet$Name(null);
            } else {
                ((RegisterRealmProxyInterface) obj).realmSet$Name((String) json.getString("Name"));
            }
        }
        if (json.has("Email")) {
            if (json.isNull("Email")) {
                ((RegisterRealmProxyInterface) obj).realmSet$Email(null);
            } else {
                ((RegisterRealmProxyInterface) obj).realmSet$Email((String) json.getString("Email"));
            }
        }
        if (json.has("Password")) {
            if (json.isNull("Password")) {
                ((RegisterRealmProxyInterface) obj).realmSet$Password(null);
            } else {
                ((RegisterRealmProxyInterface) obj).realmSet$Password((String) json.getString("Password"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static org.snowcorp.app.model.Register createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        org.snowcorp.app.model.Register obj = new org.snowcorp.app.model.Register();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("ID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ID' to null.");
                } else {
                    ((RegisterRealmProxyInterface) obj).realmSet$ID((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("Name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((RegisterRealmProxyInterface) obj).realmSet$Name(null);
                } else {
                    ((RegisterRealmProxyInterface) obj).realmSet$Name((String) reader.nextString());
                }
            } else if (name.equals("Email")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((RegisterRealmProxyInterface) obj).realmSet$Email(null);
                } else {
                    ((RegisterRealmProxyInterface) obj).realmSet$Email((String) reader.nextString());
                }
            } else if (name.equals("Password")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((RegisterRealmProxyInterface) obj).realmSet$Password(null);
                } else {
                    ((RegisterRealmProxyInterface) obj).realmSet$Password((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'ID'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static org.snowcorp.app.model.Register copyOrUpdate(Realm realm, org.snowcorp.app.model.Register object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.Register) cachedRealmObject;
        } else {
            org.snowcorp.app.model.Register realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(org.snowcorp.app.model.Register.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((RegisterRealmProxyInterface) object).realmGet$ID());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.Register.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.RegisterRealmProxy();
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

    public static org.snowcorp.app.model.Register copy(Realm realm, org.snowcorp.app.model.Register newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.Register) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            org.snowcorp.app.model.Register realmObject = realm.createObjectInternal(org.snowcorp.app.model.Register.class, ((RegisterRealmProxyInterface) newObject).realmGet$ID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((RegisterRealmProxyInterface) realmObject).realmSet$Name(((RegisterRealmProxyInterface) newObject).realmGet$Name());
            ((RegisterRealmProxyInterface) realmObject).realmSet$Email(((RegisterRealmProxyInterface) newObject).realmGet$Email());
            ((RegisterRealmProxyInterface) realmObject).realmSet$Password(((RegisterRealmProxyInterface) newObject).realmGet$Password());
            return realmObject;
        }
    }

    public static long insert(Realm realm, org.snowcorp.app.model.Register object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.Register.class);
        long tableNativePtr = table.getNativePtr();
        RegisterColumnInfo columnInfo = (RegisterColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Register.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((RegisterRealmProxyInterface) object).realmGet$ID();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RegisterRealmProxyInterface) object).realmGet$ID());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((RegisterRealmProxyInterface) object).realmGet$ID());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$Name = ((RegisterRealmProxyInterface)object).realmGet$Name();
        if (realmGet$Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
        }
        String realmGet$Email = ((RegisterRealmProxyInterface)object).realmGet$Email();
        if (realmGet$Email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EmailIndex, rowIndex, realmGet$Email, false);
        }
        String realmGet$Password = ((RegisterRealmProxyInterface)object).realmGet$Password();
        if (realmGet$Password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PasswordIndex, rowIndex, realmGet$Password, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.Register.class);
        long tableNativePtr = table.getNativePtr();
        RegisterColumnInfo columnInfo = (RegisterColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Register.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.Register object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.Register) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((RegisterRealmProxyInterface) object).realmGet$ID();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RegisterRealmProxyInterface) object).realmGet$ID());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((RegisterRealmProxyInterface) object).realmGet$ID());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$Name = ((RegisterRealmProxyInterface)object).realmGet$Name();
                if (realmGet$Name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
                }
                String realmGet$Email = ((RegisterRealmProxyInterface)object).realmGet$Email();
                if (realmGet$Email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.EmailIndex, rowIndex, realmGet$Email, false);
                }
                String realmGet$Password = ((RegisterRealmProxyInterface)object).realmGet$Password();
                if (realmGet$Password != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.PasswordIndex, rowIndex, realmGet$Password, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, org.snowcorp.app.model.Register object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.Register.class);
        long tableNativePtr = table.getNativePtr();
        RegisterColumnInfo columnInfo = (RegisterColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Register.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((RegisterRealmProxyInterface) object).realmGet$ID();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RegisterRealmProxyInterface) object).realmGet$ID());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((RegisterRealmProxyInterface) object).realmGet$ID());
        }
        cache.put(object, rowIndex);
        String realmGet$Name = ((RegisterRealmProxyInterface)object).realmGet$Name();
        if (realmGet$Name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.NameIndex, rowIndex, false);
        }
        String realmGet$Email = ((RegisterRealmProxyInterface)object).realmGet$Email();
        if (realmGet$Email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.EmailIndex, rowIndex, realmGet$Email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.EmailIndex, rowIndex, false);
        }
        String realmGet$Password = ((RegisterRealmProxyInterface)object).realmGet$Password();
        if (realmGet$Password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.PasswordIndex, rowIndex, realmGet$Password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.PasswordIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.Register.class);
        long tableNativePtr = table.getNativePtr();
        RegisterColumnInfo columnInfo = (RegisterColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Register.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.Register object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.Register) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((RegisterRealmProxyInterface) object).realmGet$ID();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((RegisterRealmProxyInterface) object).realmGet$ID());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((RegisterRealmProxyInterface) object).realmGet$ID());
                }
                cache.put(object, rowIndex);
                String realmGet$Name = ((RegisterRealmProxyInterface)object).realmGet$Name();
                if (realmGet$Name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.NameIndex, rowIndex, realmGet$Name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.NameIndex, rowIndex, false);
                }
                String realmGet$Email = ((RegisterRealmProxyInterface)object).realmGet$Email();
                if (realmGet$Email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.EmailIndex, rowIndex, realmGet$Email, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.EmailIndex, rowIndex, false);
                }
                String realmGet$Password = ((RegisterRealmProxyInterface)object).realmGet$Password();
                if (realmGet$Password != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.PasswordIndex, rowIndex, realmGet$Password, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.PasswordIndex, rowIndex, false);
                }
            }
        }
    }

    public static org.snowcorp.app.model.Register createDetachedCopy(org.snowcorp.app.model.Register realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        org.snowcorp.app.model.Register unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (org.snowcorp.app.model.Register)cachedObject.object;
            } else {
                unmanagedObject = (org.snowcorp.app.model.Register)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new org.snowcorp.app.model.Register();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((RegisterRealmProxyInterface) unmanagedObject).realmSet$ID(((RegisterRealmProxyInterface) realmObject).realmGet$ID());
        ((RegisterRealmProxyInterface) unmanagedObject).realmSet$Name(((RegisterRealmProxyInterface) realmObject).realmGet$Name());
        ((RegisterRealmProxyInterface) unmanagedObject).realmSet$Email(((RegisterRealmProxyInterface) realmObject).realmGet$Email());
        ((RegisterRealmProxyInterface) unmanagedObject).realmSet$Password(((RegisterRealmProxyInterface) realmObject).realmGet$Password());
        return unmanagedObject;
    }

    static org.snowcorp.app.model.Register update(Realm realm, org.snowcorp.app.model.Register realmObject, org.snowcorp.app.model.Register newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((RegisterRealmProxyInterface) realmObject).realmSet$Name(((RegisterRealmProxyInterface) newObject).realmGet$Name());
        ((RegisterRealmProxyInterface) realmObject).realmSet$Email(((RegisterRealmProxyInterface) newObject).realmGet$Email());
        ((RegisterRealmProxyInterface) realmObject).realmSet$Password(((RegisterRealmProxyInterface) newObject).realmGet$Password());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Register = proxy[");
        stringBuilder.append("{ID:");
        stringBuilder.append(realmGet$ID());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Name:");
        stringBuilder.append(realmGet$Name() != null ? realmGet$Name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Email:");
        stringBuilder.append(realmGet$Email() != null ? realmGet$Email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{Password:");
        stringBuilder.append(realmGet$Password() != null ? realmGet$Password() : "null");
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
        RegisterRealmProxy aRegister = (RegisterRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRegister.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRegister.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRegister.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
