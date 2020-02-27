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

public class ProductionCompanyRealmProxy extends org.snowcorp.app.model.ProductionCompany
    implements RealmObjectProxy, ProductionCompanyRealmProxyInterface {

    static final class ProductionCompanyColumnInfo extends ColumnInfo {
        long idIndex;
        long logoPathIndex;
        long nameIndex;
        long originCountryIndex;

        ProductionCompanyColumnInfo(SharedRealm realm, Table table) {
            super(4);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.logoPathIndex = addColumnDetails(table, "logoPath", RealmFieldType.STRING);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.originCountryIndex = addColumnDetails(table, "originCountry", RealmFieldType.STRING);
        }

        ProductionCompanyColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ProductionCompanyColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ProductionCompanyColumnInfo src = (ProductionCompanyColumnInfo) rawSrc;
            final ProductionCompanyColumnInfo dst = (ProductionCompanyColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.logoPathIndex = src.logoPathIndex;
            dst.nameIndex = src.nameIndex;
            dst.originCountryIndex = src.originCountryIndex;
        }
    }

    private ProductionCompanyColumnInfo columnInfo;
    private ProxyState<org.snowcorp.app.model.ProductionCompany> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("logoPath");
        fieldNames.add("name");
        fieldNames.add("originCountry");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ProductionCompanyRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProductionCompanyColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<org.snowcorp.app.model.ProductionCompany>(this);
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
    public String realmGet$logoPath() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.logoPathIndex);
    }

    @Override
    public void realmSet$logoPath(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.logoPathIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.logoPathIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.logoPathIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.logoPathIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$originCountry() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.originCountryIndex);
    }

    @Override
    public void realmSet$originCountry(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.originCountryIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.originCountryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.originCountryIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.originCountryIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("ProductionCompany")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ProductionCompany");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("logoPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("originCountry", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("ProductionCompany");
    }

    public static ProductionCompanyColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_ProductionCompany")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ProductionCompany' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_ProductionCompany");
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

        final ProductionCompanyColumnInfo columnInfo = new ProductionCompanyColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("logoPath")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'logoPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("logoPath") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'logoPath' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.logoPathIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'logoPath' is required. Either set @Required to field 'logoPath' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("name")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("name") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("originCountry")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'originCountry' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("originCountry") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'originCountry' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.originCountryIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'originCountry' is required. Either set @Required to field 'originCountry' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_ProductionCompany";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static org.snowcorp.app.model.ProductionCompany createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        org.snowcorp.app.model.ProductionCompany obj = null;
        if (update) {
            Table table = realm.getTable(org.snowcorp.app.model.ProductionCompany.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.ProductionCompany.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ProductionCompanyRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.ProductionCompanyRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.ProductionCompany.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ProductionCompanyRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.ProductionCompany.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("logoPath")) {
            if (json.isNull("logoPath")) {
                ((ProductionCompanyRealmProxyInterface) obj).realmSet$logoPath(null);
            } else {
                ((ProductionCompanyRealmProxyInterface) obj).realmSet$logoPath((String) json.getString("logoPath"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((ProductionCompanyRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((ProductionCompanyRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("originCountry")) {
            if (json.isNull("originCountry")) {
                ((ProductionCompanyRealmProxyInterface) obj).realmSet$originCountry(null);
            } else {
                ((ProductionCompanyRealmProxyInterface) obj).realmSet$originCountry((String) json.getString("originCountry"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static org.snowcorp.app.model.ProductionCompany createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        org.snowcorp.app.model.ProductionCompany obj = new org.snowcorp.app.model.ProductionCompany();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductionCompanyRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((ProductionCompanyRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("logoPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductionCompanyRealmProxyInterface) obj).realmSet$logoPath(null);
                } else {
                    ((ProductionCompanyRealmProxyInterface) obj).realmSet$logoPath((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductionCompanyRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((ProductionCompanyRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("originCountry")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductionCompanyRealmProxyInterface) obj).realmSet$originCountry(null);
                } else {
                    ((ProductionCompanyRealmProxyInterface) obj).realmSet$originCountry((String) reader.nextString());
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

    public static org.snowcorp.app.model.ProductionCompany copyOrUpdate(Realm realm, org.snowcorp.app.model.ProductionCompany object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.ProductionCompany) cachedRealmObject;
        } else {
            org.snowcorp.app.model.ProductionCompany realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(org.snowcorp.app.model.ProductionCompany.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((ProductionCompanyRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.ProductionCompany.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ProductionCompanyRealmProxy();
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

    public static org.snowcorp.app.model.ProductionCompany copy(Realm realm, org.snowcorp.app.model.ProductionCompany newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.ProductionCompany) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            org.snowcorp.app.model.ProductionCompany realmObject = realm.createObjectInternal(org.snowcorp.app.model.ProductionCompany.class, ((ProductionCompanyRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ProductionCompanyRealmProxyInterface) realmObject).realmSet$logoPath(((ProductionCompanyRealmProxyInterface) newObject).realmGet$logoPath());
            ((ProductionCompanyRealmProxyInterface) realmObject).realmSet$name(((ProductionCompanyRealmProxyInterface) newObject).realmGet$name());
            ((ProductionCompanyRealmProxyInterface) realmObject).realmSet$originCountry(((ProductionCompanyRealmProxyInterface) newObject).realmGet$originCountry());
            return realmObject;
        }
    }

    public static long insert(Realm realm, org.snowcorp.app.model.ProductionCompany object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.ProductionCompany.class);
        long tableNativePtr = table.getNativePtr();
        ProductionCompanyColumnInfo columnInfo = (ProductionCompanyColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.ProductionCompany.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((ProductionCompanyRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ProductionCompanyRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ProductionCompanyRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$logoPath = ((ProductionCompanyRealmProxyInterface)object).realmGet$logoPath();
        if (realmGet$logoPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.logoPathIndex, rowIndex, realmGet$logoPath, false);
        }
        String realmGet$name = ((ProductionCompanyRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$originCountry = ((ProductionCompanyRealmProxyInterface)object).realmGet$originCountry();
        if (realmGet$originCountry != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.ProductionCompany.class);
        long tableNativePtr = table.getNativePtr();
        ProductionCompanyColumnInfo columnInfo = (ProductionCompanyColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.ProductionCompany.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.ProductionCompany object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.ProductionCompany) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((ProductionCompanyRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ProductionCompanyRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ProductionCompanyRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$logoPath = ((ProductionCompanyRealmProxyInterface)object).realmGet$logoPath();
                if (realmGet$logoPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.logoPathIndex, rowIndex, realmGet$logoPath, false);
                }
                String realmGet$name = ((ProductionCompanyRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$originCountry = ((ProductionCompanyRealmProxyInterface)object).realmGet$originCountry();
                if (realmGet$originCountry != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, org.snowcorp.app.model.ProductionCompany object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.ProductionCompany.class);
        long tableNativePtr = table.getNativePtr();
        ProductionCompanyColumnInfo columnInfo = (ProductionCompanyColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.ProductionCompany.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((ProductionCompanyRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ProductionCompanyRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ProductionCompanyRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$logoPath = ((ProductionCompanyRealmProxyInterface)object).realmGet$logoPath();
        if (realmGet$logoPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.logoPathIndex, rowIndex, realmGet$logoPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.logoPathIndex, rowIndex, false);
        }
        String realmGet$name = ((ProductionCompanyRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$originCountry = ((ProductionCompanyRealmProxyInterface)object).realmGet$originCountry();
        if (realmGet$originCountry != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originCountryIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.ProductionCompany.class);
        long tableNativePtr = table.getNativePtr();
        ProductionCompanyColumnInfo columnInfo = (ProductionCompanyColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.ProductionCompany.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.ProductionCompany object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.ProductionCompany) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((ProductionCompanyRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ProductionCompanyRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ProductionCompanyRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                String realmGet$logoPath = ((ProductionCompanyRealmProxyInterface)object).realmGet$logoPath();
                if (realmGet$logoPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.logoPathIndex, rowIndex, realmGet$logoPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.logoPathIndex, rowIndex, false);
                }
                String realmGet$name = ((ProductionCompanyRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$originCountry = ((ProductionCompanyRealmProxyInterface)object).realmGet$originCountry();
                if (realmGet$originCountry != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originCountryIndex, rowIndex, realmGet$originCountry, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originCountryIndex, rowIndex, false);
                }
            }
        }
    }

    public static org.snowcorp.app.model.ProductionCompany createDetachedCopy(org.snowcorp.app.model.ProductionCompany realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        org.snowcorp.app.model.ProductionCompany unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (org.snowcorp.app.model.ProductionCompany)cachedObject.object;
            } else {
                unmanagedObject = (org.snowcorp.app.model.ProductionCompany)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new org.snowcorp.app.model.ProductionCompany();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ProductionCompanyRealmProxyInterface) unmanagedObject).realmSet$id(((ProductionCompanyRealmProxyInterface) realmObject).realmGet$id());
        ((ProductionCompanyRealmProxyInterface) unmanagedObject).realmSet$logoPath(((ProductionCompanyRealmProxyInterface) realmObject).realmGet$logoPath());
        ((ProductionCompanyRealmProxyInterface) unmanagedObject).realmSet$name(((ProductionCompanyRealmProxyInterface) realmObject).realmGet$name());
        ((ProductionCompanyRealmProxyInterface) unmanagedObject).realmSet$originCountry(((ProductionCompanyRealmProxyInterface) realmObject).realmGet$originCountry());
        return unmanagedObject;
    }

    static org.snowcorp.app.model.ProductionCompany update(Realm realm, org.snowcorp.app.model.ProductionCompany realmObject, org.snowcorp.app.model.ProductionCompany newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ProductionCompanyRealmProxyInterface) realmObject).realmSet$logoPath(((ProductionCompanyRealmProxyInterface) newObject).realmGet$logoPath());
        ((ProductionCompanyRealmProxyInterface) realmObject).realmSet$name(((ProductionCompanyRealmProxyInterface) newObject).realmGet$name());
        ((ProductionCompanyRealmProxyInterface) realmObject).realmSet$originCountry(((ProductionCompanyRealmProxyInterface) newObject).realmGet$originCountry());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ProductionCompany = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{logoPath:");
        stringBuilder.append(realmGet$logoPath() != null ? realmGet$logoPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originCountry:");
        stringBuilder.append(realmGet$originCountry() != null ? realmGet$originCountry() : "null");
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
        ProductionCompanyRealmProxy aProductionCompany = (ProductionCompanyRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProductionCompany.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProductionCompany.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProductionCompany.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
