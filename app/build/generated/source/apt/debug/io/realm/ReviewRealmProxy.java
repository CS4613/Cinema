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

public class ReviewRealmProxy extends org.snowcorp.app.model.Review
    implements RealmObjectProxy, ReviewRealmProxyInterface {

    static final class ReviewColumnInfo extends ColumnInfo {
        long idIndex;
        long pageIndex;
        long ReviewResultsIndex;
        long totalPagesIndex;
        long totalResultsIndex;
        long movieIDIndex;

        ReviewColumnInfo(SharedRealm realm, Table table) {
            super(6);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.pageIndex = addColumnDetails(table, "page", RealmFieldType.INTEGER);
            this.ReviewResultsIndex = addColumnDetails(table, "ReviewResults", RealmFieldType.LIST);
            this.totalPagesIndex = addColumnDetails(table, "totalPages", RealmFieldType.INTEGER);
            this.totalResultsIndex = addColumnDetails(table, "totalResults", RealmFieldType.INTEGER);
            this.movieIDIndex = addColumnDetails(table, "movieID", RealmFieldType.INTEGER);
        }

        ReviewColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ReviewColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ReviewColumnInfo src = (ReviewColumnInfo) rawSrc;
            final ReviewColumnInfo dst = (ReviewColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.pageIndex = src.pageIndex;
            dst.ReviewResultsIndex = src.ReviewResultsIndex;
            dst.totalPagesIndex = src.totalPagesIndex;
            dst.totalResultsIndex = src.totalResultsIndex;
            dst.movieIDIndex = src.movieIDIndex;
        }
    }

    private ReviewColumnInfo columnInfo;
    private ProxyState<org.snowcorp.app.model.Review> proxyState;
    private RealmList<org.snowcorp.app.model.ReviewResult> ReviewResultsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("page");
        fieldNames.add("ReviewResults");
        fieldNames.add("totalPages");
        fieldNames.add("totalResults");
        fieldNames.add("movieID");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ReviewRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ReviewColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<org.snowcorp.app.model.Review>(this);
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
    public Integer realmGet$page() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.pageIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.pageIndex);
    }

    @Override
    public void realmSet$page(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.pageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.pageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.pageIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.pageIndex, value);
    }

    @Override
    public RealmList<org.snowcorp.app.model.ReviewResult> realmGet$ReviewResults() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (ReviewResultsRealmList != null) {
            return ReviewResultsRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.ReviewResultsIndex);
            ReviewResultsRealmList = new RealmList<org.snowcorp.app.model.ReviewResult>(org.snowcorp.app.model.ReviewResult.class, linkView, proxyState.getRealm$realm());
            return ReviewResultsRealmList;
        }
    }

    @Override
    public void realmSet$ReviewResults(RealmList<org.snowcorp.app.model.ReviewResult> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("ReviewResults")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<org.snowcorp.app.model.ReviewResult> original = value;
                value = new RealmList<org.snowcorp.app.model.ReviewResult>();
                for (org.snowcorp.app.model.ReviewResult item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.ReviewResultsIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$totalPages() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.totalPagesIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalPagesIndex);
    }

    @Override
    public void realmSet$totalPages(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.totalPagesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.totalPagesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalPagesIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.totalPagesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$totalResults() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.totalResultsIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalResultsIndex);
    }

    @Override
    public void realmSet$totalResults(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.totalResultsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.totalResultsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalResultsIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.totalResultsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$movieID() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.movieIDIndex);
    }

    @Override
    public void realmSet$movieID(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.movieIDIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.movieIDIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Review")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Review");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("page", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("ReviewResult")) {
                ReviewResultRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("ReviewResults", RealmFieldType.LIST, realmSchema.get("ReviewResult"));
            realmObjectSchema.add("totalPages", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("totalResults", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("movieID", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Review");
    }

    public static ReviewColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Review")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Review' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Review");
        final long columnCount = table.getColumnCount();
        if (columnCount != 6) {
            if (columnCount < 6) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 6 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 6 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 6 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final ReviewColumnInfo columnInfo = new ReviewColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("page")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'page' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("page") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'page' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.pageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'page' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'page' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("ReviewResults")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'ReviewResults'");
        }
        if (columnTypes.get("ReviewResults") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'ReviewResult' for field 'ReviewResults'");
        }
        if (!sharedRealm.hasTable("class_ReviewResult")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_ReviewResult' for field 'ReviewResults'");
        }
        Table table_2 = sharedRealm.getTable("class_ReviewResult");
        if (!table.getLinkTarget(columnInfo.ReviewResultsIndex).hasSameSchema(table_2)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'ReviewResults': '" + table.getLinkTarget(columnInfo.ReviewResultsIndex).getName() + "' expected - was '" + table_2.getName() + "'");
        }
        if (!columnTypes.containsKey("totalPages")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalPages' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalPages") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'totalPages' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.totalPagesIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'totalPages' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'totalPages' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalResults")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalResults' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalResults") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'totalResults' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.totalResultsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'totalResults' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'totalResults' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("movieID")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'movieID' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("movieID") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'movieID' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.movieIDIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'movieID' does support null values in the existing Realm file. Use corresponding boxed type for field 'movieID' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Review";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static org.snowcorp.app.model.Review createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        org.snowcorp.app.model.Review obj = null;
        if (update) {
            Table table = realm.getTable(org.snowcorp.app.model.Review.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.Review.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ReviewRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("ReviewResults")) {
                excludeFields.add("ReviewResults");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.ReviewRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.Review.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ReviewRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.Review.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("page")) {
            if (json.isNull("page")) {
                ((ReviewRealmProxyInterface) obj).realmSet$page(null);
            } else {
                ((ReviewRealmProxyInterface) obj).realmSet$page((int) json.getInt("page"));
            }
        }
        if (json.has("ReviewResults")) {
            if (json.isNull("ReviewResults")) {
                ((ReviewRealmProxyInterface) obj).realmSet$ReviewResults(null);
            } else {
                ((ReviewRealmProxyInterface) obj).realmGet$ReviewResults().clear();
                JSONArray array = json.getJSONArray("ReviewResults");
                for (int i = 0; i < array.length(); i++) {
                    org.snowcorp.app.model.ReviewResult item = ReviewResultRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((ReviewRealmProxyInterface) obj).realmGet$ReviewResults().add(item);
                }
            }
        }
        if (json.has("totalPages")) {
            if (json.isNull("totalPages")) {
                ((ReviewRealmProxyInterface) obj).realmSet$totalPages(null);
            } else {
                ((ReviewRealmProxyInterface) obj).realmSet$totalPages((int) json.getInt("totalPages"));
            }
        }
        if (json.has("totalResults")) {
            if (json.isNull("totalResults")) {
                ((ReviewRealmProxyInterface) obj).realmSet$totalResults(null);
            } else {
                ((ReviewRealmProxyInterface) obj).realmSet$totalResults((int) json.getInt("totalResults"));
            }
        }
        if (json.has("movieID")) {
            if (json.isNull("movieID")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'movieID' to null.");
            } else {
                ((ReviewRealmProxyInterface) obj).realmSet$movieID((int) json.getInt("movieID"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static org.snowcorp.app.model.Review createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        org.snowcorp.app.model.Review obj = new org.snowcorp.app.model.Review();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ReviewRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((ReviewRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("page")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ReviewRealmProxyInterface) obj).realmSet$page(null);
                } else {
                    ((ReviewRealmProxyInterface) obj).realmSet$page((int) reader.nextInt());
                }
            } else if (name.equals("ReviewResults")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ReviewRealmProxyInterface) obj).realmSet$ReviewResults(null);
                } else {
                    ((ReviewRealmProxyInterface) obj).realmSet$ReviewResults(new RealmList<org.snowcorp.app.model.ReviewResult>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        org.snowcorp.app.model.ReviewResult item = ReviewResultRealmProxy.createUsingJsonStream(realm, reader);
                        ((ReviewRealmProxyInterface) obj).realmGet$ReviewResults().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("totalPages")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ReviewRealmProxyInterface) obj).realmSet$totalPages(null);
                } else {
                    ((ReviewRealmProxyInterface) obj).realmSet$totalPages((int) reader.nextInt());
                }
            } else if (name.equals("totalResults")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ReviewRealmProxyInterface) obj).realmSet$totalResults(null);
                } else {
                    ((ReviewRealmProxyInterface) obj).realmSet$totalResults((int) reader.nextInt());
                }
            } else if (name.equals("movieID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'movieID' to null.");
                } else {
                    ((ReviewRealmProxyInterface) obj).realmSet$movieID((int) reader.nextInt());
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

    public static org.snowcorp.app.model.Review copyOrUpdate(Realm realm, org.snowcorp.app.model.Review object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.Review) cachedRealmObject;
        } else {
            org.snowcorp.app.model.Review realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(org.snowcorp.app.model.Review.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((ReviewRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.Review.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ReviewRealmProxy();
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

    public static org.snowcorp.app.model.Review copy(Realm realm, org.snowcorp.app.model.Review newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.Review) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            org.snowcorp.app.model.Review realmObject = realm.createObjectInternal(org.snowcorp.app.model.Review.class, ((ReviewRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ReviewRealmProxyInterface) realmObject).realmSet$page(((ReviewRealmProxyInterface) newObject).realmGet$page());

            RealmList<org.snowcorp.app.model.ReviewResult> ReviewResultsList = ((ReviewRealmProxyInterface) newObject).realmGet$ReviewResults();
            if (ReviewResultsList != null) {
                RealmList<org.snowcorp.app.model.ReviewResult> ReviewResultsRealmList = ((ReviewRealmProxyInterface) realmObject).realmGet$ReviewResults();
                for (int i = 0; i < ReviewResultsList.size(); i++) {
                    org.snowcorp.app.model.ReviewResult ReviewResultsItem = ReviewResultsList.get(i);
                    org.snowcorp.app.model.ReviewResult cacheReviewResults = (org.snowcorp.app.model.ReviewResult) cache.get(ReviewResultsItem);
                    if (cacheReviewResults != null) {
                        ReviewResultsRealmList.add(cacheReviewResults);
                    } else {
                        ReviewResultsRealmList.add(ReviewResultRealmProxy.copyOrUpdate(realm, ReviewResultsList.get(i), update, cache));
                    }
                }
            }

            ((ReviewRealmProxyInterface) realmObject).realmSet$totalPages(((ReviewRealmProxyInterface) newObject).realmGet$totalPages());
            ((ReviewRealmProxyInterface) realmObject).realmSet$totalResults(((ReviewRealmProxyInterface) newObject).realmGet$totalResults());
            ((ReviewRealmProxyInterface) realmObject).realmSet$movieID(((ReviewRealmProxyInterface) newObject).realmGet$movieID());
            return realmObject;
        }
    }

    public static long insert(Realm realm, org.snowcorp.app.model.Review object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.Review.class);
        long tableNativePtr = table.getNativePtr();
        ReviewColumnInfo columnInfo = (ReviewColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Review.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((ReviewRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReviewRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ReviewRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Number realmGet$page = ((ReviewRealmProxyInterface)object).realmGet$page();
        if (realmGet$page != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page.longValue(), false);
        }

        RealmList<org.snowcorp.app.model.ReviewResult> ReviewResultsList = ((ReviewRealmProxyInterface) object).realmGet$ReviewResults();
        if (ReviewResultsList != null) {
            long ReviewResultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.ReviewResultsIndex, rowIndex);
            for (org.snowcorp.app.model.ReviewResult ReviewResultsItem : ReviewResultsList) {
                Long cacheItemIndexReviewResults = cache.get(ReviewResultsItem);
                if (cacheItemIndexReviewResults == null) {
                    cacheItemIndexReviewResults = ReviewResultRealmProxy.insert(realm, ReviewResultsItem, cache);
                }
                LinkView.nativeAdd(ReviewResultsNativeLinkViewPtr, cacheItemIndexReviewResults);
            }
        }

        Number realmGet$totalPages = ((ReviewRealmProxyInterface)object).realmGet$totalPages();
        if (realmGet$totalPages != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
        }
        Number realmGet$totalResults = ((ReviewRealmProxyInterface)object).realmGet$totalResults();
        if (realmGet$totalResults != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((ReviewRealmProxyInterface)object).realmGet$movieID(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.Review.class);
        long tableNativePtr = table.getNativePtr();
        ReviewColumnInfo columnInfo = (ReviewColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Review.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.Review object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.Review) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((ReviewRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReviewRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ReviewRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Number realmGet$page = ((ReviewRealmProxyInterface)object).realmGet$page();
                if (realmGet$page != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page.longValue(), false);
                }

                RealmList<org.snowcorp.app.model.ReviewResult> ReviewResultsList = ((ReviewRealmProxyInterface) object).realmGet$ReviewResults();
                if (ReviewResultsList != null) {
                    long ReviewResultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.ReviewResultsIndex, rowIndex);
                    for (org.snowcorp.app.model.ReviewResult ReviewResultsItem : ReviewResultsList) {
                        Long cacheItemIndexReviewResults = cache.get(ReviewResultsItem);
                        if (cacheItemIndexReviewResults == null) {
                            cacheItemIndexReviewResults = ReviewResultRealmProxy.insert(realm, ReviewResultsItem, cache);
                        }
                        LinkView.nativeAdd(ReviewResultsNativeLinkViewPtr, cacheItemIndexReviewResults);
                    }
                }

                Number realmGet$totalPages = ((ReviewRealmProxyInterface)object).realmGet$totalPages();
                if (realmGet$totalPages != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
                }
                Number realmGet$totalResults = ((ReviewRealmProxyInterface)object).realmGet$totalResults();
                if (realmGet$totalResults != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((ReviewRealmProxyInterface)object).realmGet$movieID(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, org.snowcorp.app.model.Review object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.Review.class);
        long tableNativePtr = table.getNativePtr();
        ReviewColumnInfo columnInfo = (ReviewColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Review.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((ReviewRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReviewRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ReviewRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Number realmGet$page = ((ReviewRealmProxyInterface)object).realmGet$page();
        if (realmGet$page != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pageIndex, rowIndex, false);
        }

        long ReviewResultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.ReviewResultsIndex, rowIndex);
        LinkView.nativeClear(ReviewResultsNativeLinkViewPtr);
        RealmList<org.snowcorp.app.model.ReviewResult> ReviewResultsList = ((ReviewRealmProxyInterface) object).realmGet$ReviewResults();
        if (ReviewResultsList != null) {
            for (org.snowcorp.app.model.ReviewResult ReviewResultsItem : ReviewResultsList) {
                Long cacheItemIndexReviewResults = cache.get(ReviewResultsItem);
                if (cacheItemIndexReviewResults == null) {
                    cacheItemIndexReviewResults = ReviewResultRealmProxy.insertOrUpdate(realm, ReviewResultsItem, cache);
                }
                LinkView.nativeAdd(ReviewResultsNativeLinkViewPtr, cacheItemIndexReviewResults);
            }
        }

        Number realmGet$totalPages = ((ReviewRealmProxyInterface)object).realmGet$totalPages();
        if (realmGet$totalPages != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, false);
        }
        Number realmGet$totalResults = ((ReviewRealmProxyInterface)object).realmGet$totalResults();
        if (realmGet$totalResults != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((ReviewRealmProxyInterface)object).realmGet$movieID(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.Review.class);
        long tableNativePtr = table.getNativePtr();
        ReviewColumnInfo columnInfo = (ReviewColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Review.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.Review object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.Review) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((ReviewRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ReviewRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ReviewRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                Number realmGet$page = ((ReviewRealmProxyInterface)object).realmGet$page();
                if (realmGet$page != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.pageIndex, rowIndex, false);
                }

                long ReviewResultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.ReviewResultsIndex, rowIndex);
                LinkView.nativeClear(ReviewResultsNativeLinkViewPtr);
                RealmList<org.snowcorp.app.model.ReviewResult> ReviewResultsList = ((ReviewRealmProxyInterface) object).realmGet$ReviewResults();
                if (ReviewResultsList != null) {
                    for (org.snowcorp.app.model.ReviewResult ReviewResultsItem : ReviewResultsList) {
                        Long cacheItemIndexReviewResults = cache.get(ReviewResultsItem);
                        if (cacheItemIndexReviewResults == null) {
                            cacheItemIndexReviewResults = ReviewResultRealmProxy.insertOrUpdate(realm, ReviewResultsItem, cache);
                        }
                        LinkView.nativeAdd(ReviewResultsNativeLinkViewPtr, cacheItemIndexReviewResults);
                    }
                }

                Number realmGet$totalPages = ((ReviewRealmProxyInterface)object).realmGet$totalPages();
                if (realmGet$totalPages != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, false);
                }
                Number realmGet$totalResults = ((ReviewRealmProxyInterface)object).realmGet$totalResults();
                if (realmGet$totalResults != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.movieIDIndex, rowIndex, ((ReviewRealmProxyInterface)object).realmGet$movieID(), false);
            }
        }
    }

    public static org.snowcorp.app.model.Review createDetachedCopy(org.snowcorp.app.model.Review realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        org.snowcorp.app.model.Review unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (org.snowcorp.app.model.Review)cachedObject.object;
            } else {
                unmanagedObject = (org.snowcorp.app.model.Review)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new org.snowcorp.app.model.Review();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ReviewRealmProxyInterface) unmanagedObject).realmSet$id(((ReviewRealmProxyInterface) realmObject).realmGet$id());
        ((ReviewRealmProxyInterface) unmanagedObject).realmSet$page(((ReviewRealmProxyInterface) realmObject).realmGet$page());

        // Deep copy of ReviewResults
        if (currentDepth == maxDepth) {
            ((ReviewRealmProxyInterface) unmanagedObject).realmSet$ReviewResults(null);
        } else {
            RealmList<org.snowcorp.app.model.ReviewResult> managedReviewResultsList = ((ReviewRealmProxyInterface) realmObject).realmGet$ReviewResults();
            RealmList<org.snowcorp.app.model.ReviewResult> unmanagedReviewResultsList = new RealmList<org.snowcorp.app.model.ReviewResult>();
            ((ReviewRealmProxyInterface) unmanagedObject).realmSet$ReviewResults(unmanagedReviewResultsList);
            int nextDepth = currentDepth + 1;
            int size = managedReviewResultsList.size();
            for (int i = 0; i < size; i++) {
                org.snowcorp.app.model.ReviewResult item = ReviewResultRealmProxy.createDetachedCopy(managedReviewResultsList.get(i), nextDepth, maxDepth, cache);
                unmanagedReviewResultsList.add(item);
            }
        }
        ((ReviewRealmProxyInterface) unmanagedObject).realmSet$totalPages(((ReviewRealmProxyInterface) realmObject).realmGet$totalPages());
        ((ReviewRealmProxyInterface) unmanagedObject).realmSet$totalResults(((ReviewRealmProxyInterface) realmObject).realmGet$totalResults());
        ((ReviewRealmProxyInterface) unmanagedObject).realmSet$movieID(((ReviewRealmProxyInterface) realmObject).realmGet$movieID());
        return unmanagedObject;
    }

    static org.snowcorp.app.model.Review update(Realm realm, org.snowcorp.app.model.Review realmObject, org.snowcorp.app.model.Review newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ReviewRealmProxyInterface) realmObject).realmSet$page(((ReviewRealmProxyInterface) newObject).realmGet$page());
        RealmList<org.snowcorp.app.model.ReviewResult> ReviewResultsList = ((ReviewRealmProxyInterface) newObject).realmGet$ReviewResults();
        RealmList<org.snowcorp.app.model.ReviewResult> ReviewResultsRealmList = ((ReviewRealmProxyInterface) realmObject).realmGet$ReviewResults();
        ReviewResultsRealmList.clear();
        if (ReviewResultsList != null) {
            for (int i = 0; i < ReviewResultsList.size(); i++) {
                org.snowcorp.app.model.ReviewResult ReviewResultsItem = ReviewResultsList.get(i);
                org.snowcorp.app.model.ReviewResult cacheReviewResults = (org.snowcorp.app.model.ReviewResult) cache.get(ReviewResultsItem);
                if (cacheReviewResults != null) {
                    ReviewResultsRealmList.add(cacheReviewResults);
                } else {
                    ReviewResultsRealmList.add(ReviewResultRealmProxy.copyOrUpdate(realm, ReviewResultsList.get(i), true, cache));
                }
            }
        }
        ((ReviewRealmProxyInterface) realmObject).realmSet$totalPages(((ReviewRealmProxyInterface) newObject).realmGet$totalPages());
        ((ReviewRealmProxyInterface) realmObject).realmSet$totalResults(((ReviewRealmProxyInterface) newObject).realmGet$totalResults());
        ((ReviewRealmProxyInterface) realmObject).realmSet$movieID(((ReviewRealmProxyInterface) newObject).realmGet$movieID());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Review = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{page:");
        stringBuilder.append(realmGet$page() != null ? realmGet$page() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ReviewResults:");
        stringBuilder.append("RealmList<ReviewResult>[").append(realmGet$ReviewResults().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalPages:");
        stringBuilder.append(realmGet$totalPages() != null ? realmGet$totalPages() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalResults:");
        stringBuilder.append(realmGet$totalResults() != null ? realmGet$totalResults() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{movieID:");
        stringBuilder.append(realmGet$movieID());
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
        ReviewRealmProxy aReview = (ReviewRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aReview.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aReview.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aReview.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
