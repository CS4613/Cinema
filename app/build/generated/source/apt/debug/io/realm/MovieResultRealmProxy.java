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

public class MovieResultRealmProxy extends org.snowcorp.app.model.MovieResult
    implements RealmObjectProxy, MovieResultRealmProxyInterface {

    static final class MovieResultColumnInfo extends ColumnInfo {
        long voteCountIndex;
        long idIndex;
        long videoIndex;
        long voteAverageIndex;
        long titleIndex;
        long popularityIndex;
        long posterPathIndex;
        long originalLanguageIndex;
        long originalTitleIndex;
        long backdropPathIndex;
        long adultIndex;
        long overviewIndex;
        long releaseDateIndex;
        long dateTimeIndex;

        MovieResultColumnInfo(SharedRealm realm, Table table) {
            super(14);
            this.voteCountIndex = addColumnDetails(table, "voteCount", RealmFieldType.INTEGER);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.videoIndex = addColumnDetails(table, "video", RealmFieldType.BOOLEAN);
            this.voteAverageIndex = addColumnDetails(table, "voteAverage", RealmFieldType.DOUBLE);
            this.titleIndex = addColumnDetails(table, "title", RealmFieldType.STRING);
            this.popularityIndex = addColumnDetails(table, "popularity", RealmFieldType.DOUBLE);
            this.posterPathIndex = addColumnDetails(table, "posterPath", RealmFieldType.STRING);
            this.originalLanguageIndex = addColumnDetails(table, "originalLanguage", RealmFieldType.STRING);
            this.originalTitleIndex = addColumnDetails(table, "originalTitle", RealmFieldType.STRING);
            this.backdropPathIndex = addColumnDetails(table, "backdropPath", RealmFieldType.STRING);
            this.adultIndex = addColumnDetails(table, "adult", RealmFieldType.BOOLEAN);
            this.overviewIndex = addColumnDetails(table, "overview", RealmFieldType.STRING);
            this.releaseDateIndex = addColumnDetails(table, "releaseDate", RealmFieldType.STRING);
            this.dateTimeIndex = addColumnDetails(table, "dateTime", RealmFieldType.DATE);
        }

        MovieResultColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MovieResultColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MovieResultColumnInfo src = (MovieResultColumnInfo) rawSrc;
            final MovieResultColumnInfo dst = (MovieResultColumnInfo) rawDst;
            dst.voteCountIndex = src.voteCountIndex;
            dst.idIndex = src.idIndex;
            dst.videoIndex = src.videoIndex;
            dst.voteAverageIndex = src.voteAverageIndex;
            dst.titleIndex = src.titleIndex;
            dst.popularityIndex = src.popularityIndex;
            dst.posterPathIndex = src.posterPathIndex;
            dst.originalLanguageIndex = src.originalLanguageIndex;
            dst.originalTitleIndex = src.originalTitleIndex;
            dst.backdropPathIndex = src.backdropPathIndex;
            dst.adultIndex = src.adultIndex;
            dst.overviewIndex = src.overviewIndex;
            dst.releaseDateIndex = src.releaseDateIndex;
            dst.dateTimeIndex = src.dateTimeIndex;
        }
    }

    private MovieResultColumnInfo columnInfo;
    private ProxyState<org.snowcorp.app.model.MovieResult> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("voteCount");
        fieldNames.add("id");
        fieldNames.add("video");
        fieldNames.add("voteAverage");
        fieldNames.add("title");
        fieldNames.add("popularity");
        fieldNames.add("posterPath");
        fieldNames.add("originalLanguage");
        fieldNames.add("originalTitle");
        fieldNames.add("backdropPath");
        fieldNames.add("adult");
        fieldNames.add("overview");
        fieldNames.add("releaseDate");
        fieldNames.add("dateTime");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MovieResultRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MovieResultColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<org.snowcorp.app.model.MovieResult>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$voteCount() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.voteCountIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.voteCountIndex);
    }

    @Override
    public void realmSet$voteCount(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.voteCountIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.voteCountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.voteCountIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.voteCountIndex, value);
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
    public Boolean realmGet$video() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.videoIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.videoIndex);
    }

    @Override
    public void realmSet$video(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.videoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.videoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.videoIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.videoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$voteAverage() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.voteAverageIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.voteAverageIndex);
    }

    @Override
    public void realmSet$voteAverage(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.voteAverageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.voteAverageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.voteAverageIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.voteAverageIndex, value);
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
    public Double realmGet$popularity() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.popularityIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.popularityIndex);
    }

    @Override
    public void realmSet$popularity(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.popularityIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.popularityIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.popularityIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.popularityIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$posterPath() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.posterPathIndex);
    }

    @Override
    public void realmSet$posterPath(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.posterPathIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.posterPathIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.posterPathIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.posterPathIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$originalLanguage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.originalLanguageIndex);
    }

    @Override
    public void realmSet$originalLanguage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.originalLanguageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.originalLanguageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.originalLanguageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.originalLanguageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$originalTitle() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.originalTitleIndex);
    }

    @Override
    public void realmSet$originalTitle(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.originalTitleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.originalTitleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.originalTitleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.originalTitleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$backdropPath() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.backdropPathIndex);
    }

    @Override
    public void realmSet$backdropPath(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.backdropPathIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.backdropPathIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.backdropPathIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.backdropPathIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Boolean realmGet$adult() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.adultIndex)) {
            return null;
        }
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.adultIndex);
    }

    @Override
    public void realmSet$adult(Boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.adultIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setBoolean(columnInfo.adultIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.adultIndex);
            return;
        }
        proxyState.getRow$realm().setBoolean(columnInfo.adultIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$overview() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.overviewIndex);
    }

    @Override
    public void realmSet$overview(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.overviewIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.overviewIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.overviewIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.overviewIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$releaseDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.releaseDateIndex);
    }

    @Override
    public void realmSet$releaseDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.releaseDateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.releaseDateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.releaseDateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.releaseDateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$dateTime() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.dateTimeIndex)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.dateTimeIndex);
    }

    @Override
    public void realmSet$dateTime(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dateTimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDate(columnInfo.dateTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dateTimeIndex);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.dateTimeIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("MovieResult")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("MovieResult");
            realmObjectSchema.add("voteCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("video", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("voteAverage", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("popularity", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("posterPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("originalLanguage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("originalTitle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("backdropPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("adult", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("overview", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("releaseDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("dateTime", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("MovieResult");
    }

    public static MovieResultColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_MovieResult")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'MovieResult' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_MovieResult");
        final long columnCount = table.getColumnCount();
        if (columnCount != 14) {
            if (columnCount < 14) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 14 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 14 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 14 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final MovieResultColumnInfo columnInfo = new MovieResultColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            }
        }

        if (!columnTypes.containsKey("voteCount")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'voteCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("voteCount") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'voteCount' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.voteCountIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'voteCount' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'voteCount' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("video")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'video' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("video") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'video' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.videoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'video' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'video' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("voteAverage")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'voteAverage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("voteAverage") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'voteAverage' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.voteAverageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'voteAverage' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'voteAverage' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("popularity")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'popularity' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("popularity") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'popularity' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.popularityIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'popularity' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'popularity' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("posterPath")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'posterPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("posterPath") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'posterPath' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.posterPathIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'posterPath' is required. Either set @Required to field 'posterPath' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("originalLanguage")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'originalLanguage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("originalLanguage") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'originalLanguage' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.originalLanguageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'originalLanguage' is required. Either set @Required to field 'originalLanguage' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("originalTitle")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'originalTitle' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("originalTitle") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'originalTitle' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.originalTitleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'originalTitle' is required. Either set @Required to field 'originalTitle' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("backdropPath")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'backdropPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("backdropPath") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'backdropPath' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.backdropPathIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'backdropPath' is required. Either set @Required to field 'backdropPath' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("adult")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'adult' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("adult") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Boolean' for field 'adult' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.adultIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'adult' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'adult' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("overview")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'overview' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("overview") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'overview' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.overviewIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'overview' is required. Either set @Required to field 'overview' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("releaseDate")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'releaseDate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("releaseDate") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'releaseDate' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.releaseDateIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'releaseDate' is required. Either set @Required to field 'releaseDate' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("dateTime")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dateTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("dateTime") != RealmFieldType.DATE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Date' for field 'dateTime' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.dateTimeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dateTime' is required. Either set @Required to field 'dateTime' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_MovieResult";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static org.snowcorp.app.model.MovieResult createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        org.snowcorp.app.model.MovieResult obj = null;
        if (update) {
            Table table = realm.getTable(org.snowcorp.app.model.MovieResult.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.MovieResult.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MovieResultRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.MovieResultRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.MovieResult.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MovieResultRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.MovieResult.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("voteCount")) {
            if (json.isNull("voteCount")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$voteCount(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$voteCount((int) json.getInt("voteCount"));
            }
        }
        if (json.has("video")) {
            if (json.isNull("video")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$video(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$video((boolean) json.getBoolean("video"));
            }
        }
        if (json.has("voteAverage")) {
            if (json.isNull("voteAverage")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$voteAverage(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$voteAverage((double) json.getDouble("voteAverage"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("popularity")) {
            if (json.isNull("popularity")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$popularity(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$popularity((double) json.getDouble("popularity"));
            }
        }
        if (json.has("posterPath")) {
            if (json.isNull("posterPath")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$posterPath(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$posterPath((String) json.getString("posterPath"));
            }
        }
        if (json.has("originalLanguage")) {
            if (json.isNull("originalLanguage")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$originalLanguage(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$originalLanguage((String) json.getString("originalLanguage"));
            }
        }
        if (json.has("originalTitle")) {
            if (json.isNull("originalTitle")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$originalTitle(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$originalTitle((String) json.getString("originalTitle"));
            }
        }
        if (json.has("backdropPath")) {
            if (json.isNull("backdropPath")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$backdropPath(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$backdropPath((String) json.getString("backdropPath"));
            }
        }
        if (json.has("adult")) {
            if (json.isNull("adult")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$adult(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$adult((boolean) json.getBoolean("adult"));
            }
        }
        if (json.has("overview")) {
            if (json.isNull("overview")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$overview(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$overview((String) json.getString("overview"));
            }
        }
        if (json.has("releaseDate")) {
            if (json.isNull("releaseDate")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$releaseDate(null);
            } else {
                ((MovieResultRealmProxyInterface) obj).realmSet$releaseDate((String) json.getString("releaseDate"));
            }
        }
        if (json.has("dateTime")) {
            if (json.isNull("dateTime")) {
                ((MovieResultRealmProxyInterface) obj).realmSet$dateTime(null);
            } else {
                Object timestamp = json.get("dateTime");
                if (timestamp instanceof String) {
                    ((MovieResultRealmProxyInterface) obj).realmSet$dateTime(JsonUtils.stringToDate((String) timestamp));
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$dateTime(new Date(json.getLong("dateTime")));
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static org.snowcorp.app.model.MovieResult createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        org.snowcorp.app.model.MovieResult obj = new org.snowcorp.app.model.MovieResult();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("voteCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$voteCount(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$voteCount((int) reader.nextInt());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("video")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$video(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$video((boolean) reader.nextBoolean());
                }
            } else if (name.equals("voteAverage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$voteAverage(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$voteAverage((double) reader.nextDouble());
                }
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("popularity")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$popularity(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$popularity((double) reader.nextDouble());
                }
            } else if (name.equals("posterPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$posterPath(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$posterPath((String) reader.nextString());
                }
            } else if (name.equals("originalLanguage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$originalLanguage(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$originalLanguage((String) reader.nextString());
                }
            } else if (name.equals("originalTitle")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$originalTitle(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$originalTitle((String) reader.nextString());
                }
            } else if (name.equals("backdropPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$backdropPath(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$backdropPath((String) reader.nextString());
                }
            } else if (name.equals("adult")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$adult(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$adult((boolean) reader.nextBoolean());
                }
            } else if (name.equals("overview")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$overview(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$overview((String) reader.nextString());
                }
            } else if (name.equals("releaseDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$releaseDate(null);
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$releaseDate((String) reader.nextString());
                }
            } else if (name.equals("dateTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieResultRealmProxyInterface) obj).realmSet$dateTime(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        ((MovieResultRealmProxyInterface) obj).realmSet$dateTime(new Date(timestamp));
                    }
                } else {
                    ((MovieResultRealmProxyInterface) obj).realmSet$dateTime(JsonUtils.stringToDate(reader.nextString()));
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

    public static org.snowcorp.app.model.MovieResult copyOrUpdate(Realm realm, org.snowcorp.app.model.MovieResult object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.MovieResult) cachedRealmObject;
        } else {
            org.snowcorp.app.model.MovieResult realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(org.snowcorp.app.model.MovieResult.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((MovieResultRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.MovieResult.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MovieResultRealmProxy();
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

    public static org.snowcorp.app.model.MovieResult copy(Realm realm, org.snowcorp.app.model.MovieResult newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.MovieResult) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            org.snowcorp.app.model.MovieResult realmObject = realm.createObjectInternal(org.snowcorp.app.model.MovieResult.class, ((MovieResultRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MovieResultRealmProxyInterface) realmObject).realmSet$voteCount(((MovieResultRealmProxyInterface) newObject).realmGet$voteCount());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$video(((MovieResultRealmProxyInterface) newObject).realmGet$video());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$voteAverage(((MovieResultRealmProxyInterface) newObject).realmGet$voteAverage());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$title(((MovieResultRealmProxyInterface) newObject).realmGet$title());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$popularity(((MovieResultRealmProxyInterface) newObject).realmGet$popularity());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$posterPath(((MovieResultRealmProxyInterface) newObject).realmGet$posterPath());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$originalLanguage(((MovieResultRealmProxyInterface) newObject).realmGet$originalLanguage());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$originalTitle(((MovieResultRealmProxyInterface) newObject).realmGet$originalTitle());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$backdropPath(((MovieResultRealmProxyInterface) newObject).realmGet$backdropPath());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$adult(((MovieResultRealmProxyInterface) newObject).realmGet$adult());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$overview(((MovieResultRealmProxyInterface) newObject).realmGet$overview());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$releaseDate(((MovieResultRealmProxyInterface) newObject).realmGet$releaseDate());
            ((MovieResultRealmProxyInterface) realmObject).realmSet$dateTime(((MovieResultRealmProxyInterface) newObject).realmGet$dateTime());
            return realmObject;
        }
    }

    public static long insert(Realm realm, org.snowcorp.app.model.MovieResult object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.MovieResult.class);
        long tableNativePtr = table.getNativePtr();
        MovieResultColumnInfo columnInfo = (MovieResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.MovieResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((MovieResultRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieResultRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieResultRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Number realmGet$voteCount = ((MovieResultRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        }
        Boolean realmGet$video = ((MovieResultRealmProxyInterface)object).realmGet$video();
        if (realmGet$video != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
        }
        Double realmGet$voteAverage = ((MovieResultRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        }
        String realmGet$title = ((MovieResultRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        Double realmGet$popularity = ((MovieResultRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        }
        String realmGet$posterPath = ((MovieResultRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        }
        String realmGet$originalLanguage = ((MovieResultRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        }
        String realmGet$originalTitle = ((MovieResultRealmProxyInterface)object).realmGet$originalTitle();
        if (realmGet$originalTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
        }
        String realmGet$backdropPath = ((MovieResultRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        }
        Boolean realmGet$adult = ((MovieResultRealmProxyInterface)object).realmGet$adult();
        if (realmGet$adult != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
        }
        String realmGet$overview = ((MovieResultRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        }
        String realmGet$releaseDate = ((MovieResultRealmProxyInterface)object).realmGet$releaseDate();
        if (realmGet$releaseDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
        }
        java.util.Date realmGet$dateTime = ((MovieResultRealmProxyInterface)object).realmGet$dateTime();
        if (realmGet$dateTime != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime.getTime(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.MovieResult.class);
        long tableNativePtr = table.getNativePtr();
        MovieResultColumnInfo columnInfo = (MovieResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.MovieResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.MovieResult object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.MovieResult) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((MovieResultRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieResultRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieResultRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Number realmGet$voteCount = ((MovieResultRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                }
                Boolean realmGet$video = ((MovieResultRealmProxyInterface)object).realmGet$video();
                if (realmGet$video != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
                }
                Double realmGet$voteAverage = ((MovieResultRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                }
                String realmGet$title = ((MovieResultRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                Double realmGet$popularity = ((MovieResultRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                }
                String realmGet$posterPath = ((MovieResultRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                }
                String realmGet$originalLanguage = ((MovieResultRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                }
                String realmGet$originalTitle = ((MovieResultRealmProxyInterface)object).realmGet$originalTitle();
                if (realmGet$originalTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
                }
                String realmGet$backdropPath = ((MovieResultRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                }
                Boolean realmGet$adult = ((MovieResultRealmProxyInterface)object).realmGet$adult();
                if (realmGet$adult != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
                }
                String realmGet$overview = ((MovieResultRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                }
                String realmGet$releaseDate = ((MovieResultRealmProxyInterface)object).realmGet$releaseDate();
                if (realmGet$releaseDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
                }
                java.util.Date realmGet$dateTime = ((MovieResultRealmProxyInterface)object).realmGet$dateTime();
                if (realmGet$dateTime != null) {
                    Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime.getTime(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, org.snowcorp.app.model.MovieResult object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.MovieResult.class);
        long tableNativePtr = table.getNativePtr();
        MovieResultColumnInfo columnInfo = (MovieResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.MovieResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((MovieResultRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieResultRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieResultRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Number realmGet$voteCount = ((MovieResultRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
        }
        Boolean realmGet$video = ((MovieResultRealmProxyInterface)object).realmGet$video();
        if (realmGet$video != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.videoIndex, rowIndex, false);
        }
        Double realmGet$voteAverage = ((MovieResultRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
        }
        String realmGet$title = ((MovieResultRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        Double realmGet$popularity = ((MovieResultRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
        }
        String realmGet$posterPath = ((MovieResultRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
        }
        String realmGet$originalLanguage = ((MovieResultRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
        }
        String realmGet$originalTitle = ((MovieResultRealmProxyInterface)object).realmGet$originalTitle();
        if (realmGet$originalTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, false);
        }
        String realmGet$backdropPath = ((MovieResultRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
        }
        Boolean realmGet$adult = ((MovieResultRealmProxyInterface)object).realmGet$adult();
        if (realmGet$adult != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.adultIndex, rowIndex, false);
        }
        String realmGet$overview = ((MovieResultRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
        }
        String realmGet$releaseDate = ((MovieResultRealmProxyInterface)object).realmGet$releaseDate();
        if (realmGet$releaseDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, false);
        }
        java.util.Date realmGet$dateTime = ((MovieResultRealmProxyInterface)object).realmGet$dateTime();
        if (realmGet$dateTime != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.MovieResult.class);
        long tableNativePtr = table.getNativePtr();
        MovieResultColumnInfo columnInfo = (MovieResultColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.MovieResult.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.MovieResult object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.MovieResult) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((MovieResultRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieResultRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieResultRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                Number realmGet$voteCount = ((MovieResultRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
                }
                Boolean realmGet$video = ((MovieResultRealmProxyInterface)object).realmGet$video();
                if (realmGet$video != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.videoIndex, rowIndex, false);
                }
                Double realmGet$voteAverage = ((MovieResultRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
                }
                String realmGet$title = ((MovieResultRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                Double realmGet$popularity = ((MovieResultRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
                }
                String realmGet$posterPath = ((MovieResultRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
                }
                String realmGet$originalLanguage = ((MovieResultRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
                }
                String realmGet$originalTitle = ((MovieResultRealmProxyInterface)object).realmGet$originalTitle();
                if (realmGet$originalTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, false);
                }
                String realmGet$backdropPath = ((MovieResultRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
                }
                Boolean realmGet$adult = ((MovieResultRealmProxyInterface)object).realmGet$adult();
                if (realmGet$adult != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.adultIndex, rowIndex, false);
                }
                String realmGet$overview = ((MovieResultRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
                }
                String realmGet$releaseDate = ((MovieResultRealmProxyInterface)object).realmGet$releaseDate();
                if (realmGet$releaseDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, false);
                }
                java.util.Date realmGet$dateTime = ((MovieResultRealmProxyInterface)object).realmGet$dateTime();
                if (realmGet$dateTime != null) {
                    Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, realmGet$dateTime.getTime(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dateTimeIndex, rowIndex, false);
                }
            }
        }
    }

    public static org.snowcorp.app.model.MovieResult createDetachedCopy(org.snowcorp.app.model.MovieResult realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        org.snowcorp.app.model.MovieResult unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (org.snowcorp.app.model.MovieResult)cachedObject.object;
            } else {
                unmanagedObject = (org.snowcorp.app.model.MovieResult)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new org.snowcorp.app.model.MovieResult();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$voteCount(((MovieResultRealmProxyInterface) realmObject).realmGet$voteCount());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$id(((MovieResultRealmProxyInterface) realmObject).realmGet$id());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$video(((MovieResultRealmProxyInterface) realmObject).realmGet$video());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$voteAverage(((MovieResultRealmProxyInterface) realmObject).realmGet$voteAverage());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$title(((MovieResultRealmProxyInterface) realmObject).realmGet$title());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$popularity(((MovieResultRealmProxyInterface) realmObject).realmGet$popularity());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$posterPath(((MovieResultRealmProxyInterface) realmObject).realmGet$posterPath());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$originalLanguage(((MovieResultRealmProxyInterface) realmObject).realmGet$originalLanguage());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$originalTitle(((MovieResultRealmProxyInterface) realmObject).realmGet$originalTitle());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$backdropPath(((MovieResultRealmProxyInterface) realmObject).realmGet$backdropPath());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$adult(((MovieResultRealmProxyInterface) realmObject).realmGet$adult());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$overview(((MovieResultRealmProxyInterface) realmObject).realmGet$overview());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$releaseDate(((MovieResultRealmProxyInterface) realmObject).realmGet$releaseDate());
        ((MovieResultRealmProxyInterface) unmanagedObject).realmSet$dateTime(((MovieResultRealmProxyInterface) realmObject).realmGet$dateTime());
        return unmanagedObject;
    }

    static org.snowcorp.app.model.MovieResult update(Realm realm, org.snowcorp.app.model.MovieResult realmObject, org.snowcorp.app.model.MovieResult newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MovieResultRealmProxyInterface) realmObject).realmSet$voteCount(((MovieResultRealmProxyInterface) newObject).realmGet$voteCount());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$video(((MovieResultRealmProxyInterface) newObject).realmGet$video());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$voteAverage(((MovieResultRealmProxyInterface) newObject).realmGet$voteAverage());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$title(((MovieResultRealmProxyInterface) newObject).realmGet$title());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$popularity(((MovieResultRealmProxyInterface) newObject).realmGet$popularity());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$posterPath(((MovieResultRealmProxyInterface) newObject).realmGet$posterPath());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$originalLanguage(((MovieResultRealmProxyInterface) newObject).realmGet$originalLanguage());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$originalTitle(((MovieResultRealmProxyInterface) newObject).realmGet$originalTitle());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$backdropPath(((MovieResultRealmProxyInterface) newObject).realmGet$backdropPath());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$adult(((MovieResultRealmProxyInterface) newObject).realmGet$adult());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$overview(((MovieResultRealmProxyInterface) newObject).realmGet$overview());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$releaseDate(((MovieResultRealmProxyInterface) newObject).realmGet$releaseDate());
        ((MovieResultRealmProxyInterface) realmObject).realmSet$dateTime(((MovieResultRealmProxyInterface) newObject).realmGet$dateTime());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MovieResult = proxy[");
        stringBuilder.append("{voteCount:");
        stringBuilder.append(realmGet$voteCount() != null ? realmGet$voteCount() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{video:");
        stringBuilder.append(realmGet$video() != null ? realmGet$video() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{voteAverage:");
        stringBuilder.append(realmGet$voteAverage() != null ? realmGet$voteAverage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{popularity:");
        stringBuilder.append(realmGet$popularity() != null ? realmGet$popularity() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{posterPath:");
        stringBuilder.append(realmGet$posterPath() != null ? realmGet$posterPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originalLanguage:");
        stringBuilder.append(realmGet$originalLanguage() != null ? realmGet$originalLanguage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{originalTitle:");
        stringBuilder.append(realmGet$originalTitle() != null ? realmGet$originalTitle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{backdropPath:");
        stringBuilder.append(realmGet$backdropPath() != null ? realmGet$backdropPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{adult:");
        stringBuilder.append(realmGet$adult() != null ? realmGet$adult() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{overview:");
        stringBuilder.append(realmGet$overview() != null ? realmGet$overview() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{releaseDate:");
        stringBuilder.append(realmGet$releaseDate() != null ? realmGet$releaseDate() : "null");
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
        MovieResultRealmProxy aMovieResult = (MovieResultRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMovieResult.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMovieResult.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMovieResult.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
