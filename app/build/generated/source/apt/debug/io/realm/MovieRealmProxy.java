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

public class MovieRealmProxy extends org.snowcorp.app.model.Movie
    implements RealmObjectProxy, MovieRealmProxyInterface {

    static final class MovieColumnInfo extends ColumnInfo {
        long IDIndex;
        long pageIndex;
        long totalResultsIndex;
        long totalPagesIndex;
        long resultsIndex;

        MovieColumnInfo(SharedRealm realm, Table table) {
            super(5);
            this.IDIndex = addColumnDetails(table, "ID", RealmFieldType.INTEGER);
            this.pageIndex = addColumnDetails(table, "page", RealmFieldType.INTEGER);
            this.totalResultsIndex = addColumnDetails(table, "totalResults", RealmFieldType.INTEGER);
            this.totalPagesIndex = addColumnDetails(table, "totalPages", RealmFieldType.INTEGER);
            this.resultsIndex = addColumnDetails(table, "results", RealmFieldType.LIST);
        }

        MovieColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MovieColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MovieColumnInfo src = (MovieColumnInfo) rawSrc;
            final MovieColumnInfo dst = (MovieColumnInfo) rawDst;
            dst.IDIndex = src.IDIndex;
            dst.pageIndex = src.pageIndex;
            dst.totalResultsIndex = src.totalResultsIndex;
            dst.totalPagesIndex = src.totalPagesIndex;
            dst.resultsIndex = src.resultsIndex;
        }
    }

    private MovieColumnInfo columnInfo;
    private ProxyState<org.snowcorp.app.model.Movie> proxyState;
    private RealmList<org.snowcorp.app.model.MovieResult> resultsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("ID");
        fieldNames.add("page");
        fieldNames.add("totalResults");
        fieldNames.add("totalPages");
        fieldNames.add("results");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MovieRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MovieColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<org.snowcorp.app.model.Movie>(this);
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
    public RealmList<org.snowcorp.app.model.MovieResult> realmGet$results() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (resultsRealmList != null) {
            return resultsRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.resultsIndex);
            resultsRealmList = new RealmList<org.snowcorp.app.model.MovieResult>(org.snowcorp.app.model.MovieResult.class, linkView, proxyState.getRealm$realm());
            return resultsRealmList;
        }
    }

    @Override
    public void realmSet$results(RealmList<org.snowcorp.app.model.MovieResult> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("results")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<org.snowcorp.app.model.MovieResult> original = value;
                value = new RealmList<org.snowcorp.app.model.MovieResult>();
                for (org.snowcorp.app.model.MovieResult item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.resultsIndex);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Movie")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Movie");
            realmObjectSchema.add("ID", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("page", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("totalResults", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("totalPages", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("MovieResult")) {
                MovieResultRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("results", RealmFieldType.LIST, realmSchema.get("MovieResult"));
            return realmObjectSchema;
        }
        return realmSchema.get("Movie");
    }

    public static MovieColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Movie")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Movie' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Movie");
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

        final MovieColumnInfo columnInfo = new MovieColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("page")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'page' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("page") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'page' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.pageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'page' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'page' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("totalPages")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalPages' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalPages") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'totalPages' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.totalPagesIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'totalPages' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'totalPages' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("results")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'results'");
        }
        if (columnTypes.get("results") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'MovieResult' for field 'results'");
        }
        if (!sharedRealm.hasTable("class_MovieResult")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_MovieResult' for field 'results'");
        }
        Table table_4 = sharedRealm.getTable("class_MovieResult");
        if (!table.getLinkTarget(columnInfo.resultsIndex).hasSameSchema(table_4)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'results': '" + table.getLinkTarget(columnInfo.resultsIndex).getName() + "' expected - was '" + table_4.getName() + "'");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Movie";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static org.snowcorp.app.model.Movie createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        org.snowcorp.app.model.Movie obj = null;
        if (update) {
            Table table = realm.getTable(org.snowcorp.app.model.Movie.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("ID")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("ID"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.Movie.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MovieRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("results")) {
                excludeFields.add("results");
            }
            if (json.has("ID")) {
                if (json.isNull("ID")) {
                    obj = (io.realm.MovieRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.Movie.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MovieRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.Movie.class, json.getInt("ID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'ID'.");
            }
        }
        if (json.has("page")) {
            if (json.isNull("page")) {
                ((MovieRealmProxyInterface) obj).realmSet$page(null);
            } else {
                ((MovieRealmProxyInterface) obj).realmSet$page((int) json.getInt("page"));
            }
        }
        if (json.has("totalResults")) {
            if (json.isNull("totalResults")) {
                ((MovieRealmProxyInterface) obj).realmSet$totalResults(null);
            } else {
                ((MovieRealmProxyInterface) obj).realmSet$totalResults((int) json.getInt("totalResults"));
            }
        }
        if (json.has("totalPages")) {
            if (json.isNull("totalPages")) {
                ((MovieRealmProxyInterface) obj).realmSet$totalPages(null);
            } else {
                ((MovieRealmProxyInterface) obj).realmSet$totalPages((int) json.getInt("totalPages"));
            }
        }
        if (json.has("results")) {
            if (json.isNull("results")) {
                ((MovieRealmProxyInterface) obj).realmSet$results(null);
            } else {
                ((MovieRealmProxyInterface) obj).realmGet$results().clear();
                JSONArray array = json.getJSONArray("results");
                for (int i = 0; i < array.length(); i++) {
                    org.snowcorp.app.model.MovieResult item = MovieResultRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((MovieRealmProxyInterface) obj).realmGet$results().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static org.snowcorp.app.model.Movie createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        org.snowcorp.app.model.Movie obj = new org.snowcorp.app.model.Movie();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("ID")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ID' to null.");
                } else {
                    ((MovieRealmProxyInterface) obj).realmSet$ID((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("page")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieRealmProxyInterface) obj).realmSet$page(null);
                } else {
                    ((MovieRealmProxyInterface) obj).realmSet$page((int) reader.nextInt());
                }
            } else if (name.equals("totalResults")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieRealmProxyInterface) obj).realmSet$totalResults(null);
                } else {
                    ((MovieRealmProxyInterface) obj).realmSet$totalResults((int) reader.nextInt());
                }
            } else if (name.equals("totalPages")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieRealmProxyInterface) obj).realmSet$totalPages(null);
                } else {
                    ((MovieRealmProxyInterface) obj).realmSet$totalPages((int) reader.nextInt());
                }
            } else if (name.equals("results")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieRealmProxyInterface) obj).realmSet$results(null);
                } else {
                    ((MovieRealmProxyInterface) obj).realmSet$results(new RealmList<org.snowcorp.app.model.MovieResult>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        org.snowcorp.app.model.MovieResult item = MovieResultRealmProxy.createUsingJsonStream(realm, reader);
                        ((MovieRealmProxyInterface) obj).realmGet$results().add(item);
                    }
                    reader.endArray();
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

    public static org.snowcorp.app.model.Movie copyOrUpdate(Realm realm, org.snowcorp.app.model.Movie object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.Movie) cachedRealmObject;
        } else {
            org.snowcorp.app.model.Movie realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(org.snowcorp.app.model.Movie.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((MovieRealmProxyInterface) object).realmGet$ID());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.Movie.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MovieRealmProxy();
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

    public static org.snowcorp.app.model.Movie copy(Realm realm, org.snowcorp.app.model.Movie newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.Movie) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            org.snowcorp.app.model.Movie realmObject = realm.createObjectInternal(org.snowcorp.app.model.Movie.class, ((MovieRealmProxyInterface) newObject).realmGet$ID(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MovieRealmProxyInterface) realmObject).realmSet$page(((MovieRealmProxyInterface) newObject).realmGet$page());
            ((MovieRealmProxyInterface) realmObject).realmSet$totalResults(((MovieRealmProxyInterface) newObject).realmGet$totalResults());
            ((MovieRealmProxyInterface) realmObject).realmSet$totalPages(((MovieRealmProxyInterface) newObject).realmGet$totalPages());

            RealmList<org.snowcorp.app.model.MovieResult> resultsList = ((MovieRealmProxyInterface) newObject).realmGet$results();
            if (resultsList != null) {
                RealmList<org.snowcorp.app.model.MovieResult> resultsRealmList = ((MovieRealmProxyInterface) realmObject).realmGet$results();
                for (int i = 0; i < resultsList.size(); i++) {
                    org.snowcorp.app.model.MovieResult resultsItem = resultsList.get(i);
                    org.snowcorp.app.model.MovieResult cacheresults = (org.snowcorp.app.model.MovieResult) cache.get(resultsItem);
                    if (cacheresults != null) {
                        resultsRealmList.add(cacheresults);
                    } else {
                        resultsRealmList.add(MovieResultRealmProxy.copyOrUpdate(realm, resultsList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, org.snowcorp.app.model.Movie object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.Movie.class);
        long tableNativePtr = table.getNativePtr();
        MovieColumnInfo columnInfo = (MovieColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Movie.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((MovieRealmProxyInterface) object).realmGet$ID();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieRealmProxyInterface) object).realmGet$ID());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieRealmProxyInterface) object).realmGet$ID());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Number realmGet$page = ((MovieRealmProxyInterface)object).realmGet$page();
        if (realmGet$page != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page.longValue(), false);
        }
        Number realmGet$totalResults = ((MovieRealmProxyInterface)object).realmGet$totalResults();
        if (realmGet$totalResults != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
        }
        Number realmGet$totalPages = ((MovieRealmProxyInterface)object).realmGet$totalPages();
        if (realmGet$totalPages != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
        }

        RealmList<org.snowcorp.app.model.MovieResult> resultsList = ((MovieRealmProxyInterface) object).realmGet$results();
        if (resultsList != null) {
            long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
            for (org.snowcorp.app.model.MovieResult resultsItem : resultsList) {
                Long cacheItemIndexresults = cache.get(resultsItem);
                if (cacheItemIndexresults == null) {
                    cacheItemIndexresults = MovieResultRealmProxy.insert(realm, resultsItem, cache);
                }
                LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
            }
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.Movie.class);
        long tableNativePtr = table.getNativePtr();
        MovieColumnInfo columnInfo = (MovieColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Movie.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.Movie object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.Movie) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((MovieRealmProxyInterface) object).realmGet$ID();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieRealmProxyInterface) object).realmGet$ID());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieRealmProxyInterface) object).realmGet$ID());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Number realmGet$page = ((MovieRealmProxyInterface)object).realmGet$page();
                if (realmGet$page != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page.longValue(), false);
                }
                Number realmGet$totalResults = ((MovieRealmProxyInterface)object).realmGet$totalResults();
                if (realmGet$totalResults != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
                }
                Number realmGet$totalPages = ((MovieRealmProxyInterface)object).realmGet$totalPages();
                if (realmGet$totalPages != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
                }

                RealmList<org.snowcorp.app.model.MovieResult> resultsList = ((MovieRealmProxyInterface) object).realmGet$results();
                if (resultsList != null) {
                    long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
                    for (org.snowcorp.app.model.MovieResult resultsItem : resultsList) {
                        Long cacheItemIndexresults = cache.get(resultsItem);
                        if (cacheItemIndexresults == null) {
                            cacheItemIndexresults = MovieResultRealmProxy.insert(realm, resultsItem, cache);
                        }
                        LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
                    }
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, org.snowcorp.app.model.Movie object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.Movie.class);
        long tableNativePtr = table.getNativePtr();
        MovieColumnInfo columnInfo = (MovieColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Movie.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((MovieRealmProxyInterface) object).realmGet$ID();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieRealmProxyInterface) object).realmGet$ID());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieRealmProxyInterface) object).realmGet$ID());
        }
        cache.put(object, rowIndex);
        Number realmGet$page = ((MovieRealmProxyInterface)object).realmGet$page();
        if (realmGet$page != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pageIndex, rowIndex, false);
        }
        Number realmGet$totalResults = ((MovieRealmProxyInterface)object).realmGet$totalResults();
        if (realmGet$totalResults != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, false);
        }
        Number realmGet$totalPages = ((MovieRealmProxyInterface)object).realmGet$totalPages();
        if (realmGet$totalPages != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, false);
        }

        long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
        LinkView.nativeClear(resultsNativeLinkViewPtr);
        RealmList<org.snowcorp.app.model.MovieResult> resultsList = ((MovieRealmProxyInterface) object).realmGet$results();
        if (resultsList != null) {
            for (org.snowcorp.app.model.MovieResult resultsItem : resultsList) {
                Long cacheItemIndexresults = cache.get(resultsItem);
                if (cacheItemIndexresults == null) {
                    cacheItemIndexresults = MovieResultRealmProxy.insertOrUpdate(realm, resultsItem, cache);
                }
                LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.Movie.class);
        long tableNativePtr = table.getNativePtr();
        MovieColumnInfo columnInfo = (MovieColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.Movie.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.Movie object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.Movie) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((MovieRealmProxyInterface) object).realmGet$ID();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieRealmProxyInterface) object).realmGet$ID());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieRealmProxyInterface) object).realmGet$ID());
                }
                cache.put(object, rowIndex);
                Number realmGet$page = ((MovieRealmProxyInterface)object).realmGet$page();
                if (realmGet$page != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.pageIndex, rowIndex, false);
                }
                Number realmGet$totalResults = ((MovieRealmProxyInterface)object).realmGet$totalResults();
                if (realmGet$totalResults != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, realmGet$totalResults.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalResultsIndex, rowIndex, false);
                }
                Number realmGet$totalPages = ((MovieRealmProxyInterface)object).realmGet$totalPages();
                if (realmGet$totalPages != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, realmGet$totalPages.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalPagesIndex, rowIndex, false);
                }

                long resultsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.resultsIndex, rowIndex);
                LinkView.nativeClear(resultsNativeLinkViewPtr);
                RealmList<org.snowcorp.app.model.MovieResult> resultsList = ((MovieRealmProxyInterface) object).realmGet$results();
                if (resultsList != null) {
                    for (org.snowcorp.app.model.MovieResult resultsItem : resultsList) {
                        Long cacheItemIndexresults = cache.get(resultsItem);
                        if (cacheItemIndexresults == null) {
                            cacheItemIndexresults = MovieResultRealmProxy.insertOrUpdate(realm, resultsItem, cache);
                        }
                        LinkView.nativeAdd(resultsNativeLinkViewPtr, cacheItemIndexresults);
                    }
                }

            }
        }
    }

    public static org.snowcorp.app.model.Movie createDetachedCopy(org.snowcorp.app.model.Movie realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        org.snowcorp.app.model.Movie unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (org.snowcorp.app.model.Movie)cachedObject.object;
            } else {
                unmanagedObject = (org.snowcorp.app.model.Movie)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new org.snowcorp.app.model.Movie();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((MovieRealmProxyInterface) unmanagedObject).realmSet$ID(((MovieRealmProxyInterface) realmObject).realmGet$ID());
        ((MovieRealmProxyInterface) unmanagedObject).realmSet$page(((MovieRealmProxyInterface) realmObject).realmGet$page());
        ((MovieRealmProxyInterface) unmanagedObject).realmSet$totalResults(((MovieRealmProxyInterface) realmObject).realmGet$totalResults());
        ((MovieRealmProxyInterface) unmanagedObject).realmSet$totalPages(((MovieRealmProxyInterface) realmObject).realmGet$totalPages());

        // Deep copy of results
        if (currentDepth == maxDepth) {
            ((MovieRealmProxyInterface) unmanagedObject).realmSet$results(null);
        } else {
            RealmList<org.snowcorp.app.model.MovieResult> managedresultsList = ((MovieRealmProxyInterface) realmObject).realmGet$results();
            RealmList<org.snowcorp.app.model.MovieResult> unmanagedresultsList = new RealmList<org.snowcorp.app.model.MovieResult>();
            ((MovieRealmProxyInterface) unmanagedObject).realmSet$results(unmanagedresultsList);
            int nextDepth = currentDepth + 1;
            int size = managedresultsList.size();
            for (int i = 0; i < size; i++) {
                org.snowcorp.app.model.MovieResult item = MovieResultRealmProxy.createDetachedCopy(managedresultsList.get(i), nextDepth, maxDepth, cache);
                unmanagedresultsList.add(item);
            }
        }
        return unmanagedObject;
    }

    static org.snowcorp.app.model.Movie update(Realm realm, org.snowcorp.app.model.Movie realmObject, org.snowcorp.app.model.Movie newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MovieRealmProxyInterface) realmObject).realmSet$page(((MovieRealmProxyInterface) newObject).realmGet$page());
        ((MovieRealmProxyInterface) realmObject).realmSet$totalResults(((MovieRealmProxyInterface) newObject).realmGet$totalResults());
        ((MovieRealmProxyInterface) realmObject).realmSet$totalPages(((MovieRealmProxyInterface) newObject).realmGet$totalPages());
        RealmList<org.snowcorp.app.model.MovieResult> resultsList = ((MovieRealmProxyInterface) newObject).realmGet$results();
        RealmList<org.snowcorp.app.model.MovieResult> resultsRealmList = ((MovieRealmProxyInterface) realmObject).realmGet$results();
        resultsRealmList.clear();
        if (resultsList != null) {
            for (int i = 0; i < resultsList.size(); i++) {
                org.snowcorp.app.model.MovieResult resultsItem = resultsList.get(i);
                org.snowcorp.app.model.MovieResult cacheresults = (org.snowcorp.app.model.MovieResult) cache.get(resultsItem);
                if (cacheresults != null) {
                    resultsRealmList.add(cacheresults);
                } else {
                    resultsRealmList.add(MovieResultRealmProxy.copyOrUpdate(realm, resultsList.get(i), true, cache));
                }
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Movie = proxy[");
        stringBuilder.append("{ID:");
        stringBuilder.append(realmGet$ID());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{page:");
        stringBuilder.append(realmGet$page() != null ? realmGet$page() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalResults:");
        stringBuilder.append(realmGet$totalResults() != null ? realmGet$totalResults() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalPages:");
        stringBuilder.append(realmGet$totalPages() != null ? realmGet$totalPages() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{results:");
        stringBuilder.append("RealmList<MovieResult>[").append(realmGet$results().size()).append("]");
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
        MovieRealmProxy aMovie = (MovieRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMovie.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMovie.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMovie.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
