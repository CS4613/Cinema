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

public class MovieDetailsRealmProxy extends org.snowcorp.app.model.MovieDetails
    implements RealmObjectProxy, MovieDetailsRealmProxyInterface {

    static final class MovieDetailsColumnInfo extends ColumnInfo {
        long adultIndex;
        long backdropPathIndex;
        long belongsToCollectionIndex;
        long budgetIndex;
        long genresIndex;
        long homepageIndex;
        long idIndex;
        long imdbIdIndex;
        long originalLanguageIndex;
        long originalTitleIndex;
        long overviewIndex;
        long popularityIndex;
        long posterPathIndex;
        long productionCompaniesIndex;
        long releaseDateIndex;
        long revenueIndex;
        long runtimeIndex;
        long statusIndex;
        long taglineIndex;
        long titleIndex;
        long videoIndex;
        long voteAverageIndex;
        long voteCountIndex;

        MovieDetailsColumnInfo(SharedRealm realm, Table table) {
            super(23);
            this.adultIndex = addColumnDetails(table, "adult", RealmFieldType.BOOLEAN);
            this.backdropPathIndex = addColumnDetails(table, "backdropPath", RealmFieldType.STRING);
            this.belongsToCollectionIndex = addColumnDetails(table, "belongsToCollection", RealmFieldType.OBJECT);
            this.budgetIndex = addColumnDetails(table, "budget", RealmFieldType.INTEGER);
            this.genresIndex = addColumnDetails(table, "genres", RealmFieldType.LIST);
            this.homepageIndex = addColumnDetails(table, "homepage", RealmFieldType.STRING);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.imdbIdIndex = addColumnDetails(table, "imdbId", RealmFieldType.STRING);
            this.originalLanguageIndex = addColumnDetails(table, "originalLanguage", RealmFieldType.STRING);
            this.originalTitleIndex = addColumnDetails(table, "originalTitle", RealmFieldType.STRING);
            this.overviewIndex = addColumnDetails(table, "overview", RealmFieldType.STRING);
            this.popularityIndex = addColumnDetails(table, "popularity", RealmFieldType.DOUBLE);
            this.posterPathIndex = addColumnDetails(table, "posterPath", RealmFieldType.STRING);
            this.productionCompaniesIndex = addColumnDetails(table, "productionCompanies", RealmFieldType.LIST);
            this.releaseDateIndex = addColumnDetails(table, "releaseDate", RealmFieldType.STRING);
            this.revenueIndex = addColumnDetails(table, "revenue", RealmFieldType.INTEGER);
            this.runtimeIndex = addColumnDetails(table, "runtime", RealmFieldType.INTEGER);
            this.statusIndex = addColumnDetails(table, "status", RealmFieldType.STRING);
            this.taglineIndex = addColumnDetails(table, "tagline", RealmFieldType.STRING);
            this.titleIndex = addColumnDetails(table, "title", RealmFieldType.STRING);
            this.videoIndex = addColumnDetails(table, "video", RealmFieldType.BOOLEAN);
            this.voteAverageIndex = addColumnDetails(table, "voteAverage", RealmFieldType.DOUBLE);
            this.voteCountIndex = addColumnDetails(table, "voteCount", RealmFieldType.INTEGER);
        }

        MovieDetailsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MovieDetailsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MovieDetailsColumnInfo src = (MovieDetailsColumnInfo) rawSrc;
            final MovieDetailsColumnInfo dst = (MovieDetailsColumnInfo) rawDst;
            dst.adultIndex = src.adultIndex;
            dst.backdropPathIndex = src.backdropPathIndex;
            dst.belongsToCollectionIndex = src.belongsToCollectionIndex;
            dst.budgetIndex = src.budgetIndex;
            dst.genresIndex = src.genresIndex;
            dst.homepageIndex = src.homepageIndex;
            dst.idIndex = src.idIndex;
            dst.imdbIdIndex = src.imdbIdIndex;
            dst.originalLanguageIndex = src.originalLanguageIndex;
            dst.originalTitleIndex = src.originalTitleIndex;
            dst.overviewIndex = src.overviewIndex;
            dst.popularityIndex = src.popularityIndex;
            dst.posterPathIndex = src.posterPathIndex;
            dst.productionCompaniesIndex = src.productionCompaniesIndex;
            dst.releaseDateIndex = src.releaseDateIndex;
            dst.revenueIndex = src.revenueIndex;
            dst.runtimeIndex = src.runtimeIndex;
            dst.statusIndex = src.statusIndex;
            dst.taglineIndex = src.taglineIndex;
            dst.titleIndex = src.titleIndex;
            dst.videoIndex = src.videoIndex;
            dst.voteAverageIndex = src.voteAverageIndex;
            dst.voteCountIndex = src.voteCountIndex;
        }
    }

    private MovieDetailsColumnInfo columnInfo;
    private ProxyState<org.snowcorp.app.model.MovieDetails> proxyState;
    private RealmList<org.snowcorp.app.model.Genre> genresRealmList;
    private RealmList<org.snowcorp.app.model.ProductionCompany> productionCompaniesRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("adult");
        fieldNames.add("backdropPath");
        fieldNames.add("belongsToCollection");
        fieldNames.add("budget");
        fieldNames.add("genres");
        fieldNames.add("homepage");
        fieldNames.add("id");
        fieldNames.add("imdbId");
        fieldNames.add("originalLanguage");
        fieldNames.add("originalTitle");
        fieldNames.add("overview");
        fieldNames.add("popularity");
        fieldNames.add("posterPath");
        fieldNames.add("productionCompanies");
        fieldNames.add("releaseDate");
        fieldNames.add("revenue");
        fieldNames.add("runtime");
        fieldNames.add("status");
        fieldNames.add("tagline");
        fieldNames.add("title");
        fieldNames.add("video");
        fieldNames.add("voteAverage");
        fieldNames.add("voteCount");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MovieDetailsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MovieDetailsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<org.snowcorp.app.model.MovieDetails>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
    public org.snowcorp.app.model.BelongsToCollection realmGet$belongsToCollection() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.belongsToCollectionIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(org.snowcorp.app.model.BelongsToCollection.class, proxyState.getRow$realm().getLink(columnInfo.belongsToCollectionIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$belongsToCollection(org.snowcorp.app.model.BelongsToCollection value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("belongsToCollection")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.belongsToCollectionIndex);
                return;
            }
            if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
            if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            }
            row.getTable().setLink(columnInfo.belongsToCollectionIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.belongsToCollectionIndex);
            return;
        }
        if (!(RealmObject.isManaged(value) && RealmObject.isValid(value))) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.belongsToCollectionIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$budget() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.budgetIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.budgetIndex);
    }

    @Override
    public void realmSet$budget(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.budgetIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.budgetIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.budgetIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.budgetIndex, value);
    }

    @Override
    public RealmList<org.snowcorp.app.model.Genre> realmGet$genres() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (genresRealmList != null) {
            return genresRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.genresIndex);
            genresRealmList = new RealmList<org.snowcorp.app.model.Genre>(org.snowcorp.app.model.Genre.class, linkView, proxyState.getRealm$realm());
            return genresRealmList;
        }
    }

    @Override
    public void realmSet$genres(RealmList<org.snowcorp.app.model.Genre> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("genres")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<org.snowcorp.app.model.Genre> original = value;
                value = new RealmList<org.snowcorp.app.model.Genre>();
                for (org.snowcorp.app.model.Genre item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.genresIndex);
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
    public String realmGet$homepage() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.homepageIndex);
    }

    @Override
    public void realmSet$homepage(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.homepageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.homepageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.homepageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.homepageIndex, value);
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
    public String realmGet$imdbId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imdbIdIndex);
    }

    @Override
    public void realmSet$imdbId(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imdbIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imdbIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imdbIdIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imdbIdIndex, value);
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
    public RealmList<org.snowcorp.app.model.ProductionCompany> realmGet$productionCompanies() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (productionCompaniesRealmList != null) {
            return productionCompaniesRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.productionCompaniesIndex);
            productionCompaniesRealmList = new RealmList<org.snowcorp.app.model.ProductionCompany>(org.snowcorp.app.model.ProductionCompany.class, linkView, proxyState.getRealm$realm());
            return productionCompaniesRealmList;
        }
    }

    @Override
    public void realmSet$productionCompanies(RealmList<org.snowcorp.app.model.ProductionCompany> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("productionCompanies")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<org.snowcorp.app.model.ProductionCompany> original = value;
                value = new RealmList<org.snowcorp.app.model.ProductionCompany>();
                for (org.snowcorp.app.model.ProductionCompany item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.productionCompaniesIndex);
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
    public Integer realmGet$revenue() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.revenueIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.revenueIndex);
    }

    @Override
    public void realmSet$revenue(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.revenueIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.revenueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.revenueIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.revenueIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$runtime() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.runtimeIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.runtimeIndex);
    }

    @Override
    public void realmSet$runtime(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.runtimeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.runtimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.runtimeIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.runtimeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$tagline() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.taglineIndex);
    }

    @Override
    public void realmSet$tagline(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.taglineIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.taglineIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.taglineIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.taglineIndex, value);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("MovieDetails")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("MovieDetails");
            realmObjectSchema.add("adult", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("backdropPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("BelongsToCollection")) {
                BelongsToCollectionRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("belongsToCollection", RealmFieldType.OBJECT, realmSchema.get("BelongsToCollection"));
            realmObjectSchema.add("budget", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("Genre")) {
                GenreRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("genres", RealmFieldType.LIST, realmSchema.get("Genre"));
            realmObjectSchema.add("homepage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("imdbId", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("originalLanguage", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("originalTitle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("overview", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("popularity", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("posterPath", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("ProductionCompany")) {
                ProductionCompanyRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("productionCompanies", RealmFieldType.LIST, realmSchema.get("ProductionCompany"));
            realmObjectSchema.add("releaseDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("revenue", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("runtime", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("tagline", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("video", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("voteAverage", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("voteCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("MovieDetails");
    }

    public static MovieDetailsColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_MovieDetails")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'MovieDetails' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_MovieDetails");
        final long columnCount = table.getColumnCount();
        if (columnCount != 23) {
            if (columnCount < 23) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 23 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 23 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 23 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final MovieDetailsColumnInfo columnInfo = new MovieDetailsColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            }
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
        if (!columnTypes.containsKey("backdropPath")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'backdropPath' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("backdropPath") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'backdropPath' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.backdropPathIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'backdropPath' is required. Either set @Required to field 'backdropPath' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("belongsToCollection")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'belongsToCollection' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("belongsToCollection") != RealmFieldType.OBJECT) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'BelongsToCollection' for field 'belongsToCollection'");
        }
        if (!sharedRealm.hasTable("class_BelongsToCollection")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_BelongsToCollection' for field 'belongsToCollection'");
        }
        Table table_2 = sharedRealm.getTable("class_BelongsToCollection");
        if (!table.getLinkTarget(columnInfo.belongsToCollectionIndex).hasSameSchema(table_2)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmObject for field 'belongsToCollection': '" + table.getLinkTarget(columnInfo.belongsToCollectionIndex).getName() + "' expected - was '" + table_2.getName() + "'");
        }
        if (!columnTypes.containsKey("budget")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'budget' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("budget") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'budget' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.budgetIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'budget' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'budget' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("genres")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'genres'");
        }
        if (columnTypes.get("genres") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Genre' for field 'genres'");
        }
        if (!sharedRealm.hasTable("class_Genre")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Genre' for field 'genres'");
        }
        Table table_4 = sharedRealm.getTable("class_Genre");
        if (!table.getLinkTarget(columnInfo.genresIndex).hasSameSchema(table_4)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'genres': '" + table.getLinkTarget(columnInfo.genresIndex).getName() + "' expected - was '" + table_4.getName() + "'");
        }
        if (!columnTypes.containsKey("homepage")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'homepage' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("homepage") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'homepage' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.homepageIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'homepage' is required. Either set @Required to field 'homepage' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("imdbId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'imdbId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("imdbId") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'imdbId' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.imdbIdIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'imdbId' is required. Either set @Required to field 'imdbId' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("overview")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'overview' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("overview") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'overview' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.overviewIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'overview' is required. Either set @Required to field 'overview' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("productionCompanies")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productionCompanies'");
        }
        if (columnTypes.get("productionCompanies") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'ProductionCompany' for field 'productionCompanies'");
        }
        if (!sharedRealm.hasTable("class_ProductionCompany")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_ProductionCompany' for field 'productionCompanies'");
        }
        Table table_13 = sharedRealm.getTable("class_ProductionCompany");
        if (!table.getLinkTarget(columnInfo.productionCompaniesIndex).hasSameSchema(table_13)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'productionCompanies': '" + table.getLinkTarget(columnInfo.productionCompaniesIndex).getName() + "' expected - was '" + table_13.getName() + "'");
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
        if (!columnTypes.containsKey("revenue")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'revenue' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("revenue") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'revenue' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.revenueIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'revenue' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'revenue' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("runtime")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'runtime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("runtime") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'runtime' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.runtimeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'runtime' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'runtime' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("status")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'status' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("status") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'status' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.statusIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'status' is required. Either set @Required to field 'status' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("tagline")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'tagline' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("tagline") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'tagline' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.taglineIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'tagline' is required. Either set @Required to field 'tagline' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("voteCount")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'voteCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("voteCount") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'voteCount' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.voteCountIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'voteCount' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'voteCount' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_MovieDetails";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static org.snowcorp.app.model.MovieDetails createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(3);
        org.snowcorp.app.model.MovieDetails obj = null;
        if (update) {
            Table table = realm.getTable(org.snowcorp.app.model.MovieDetails.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.MovieDetails.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MovieDetailsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("belongsToCollection")) {
                excludeFields.add("belongsToCollection");
            }
            if (json.has("genres")) {
                excludeFields.add("genres");
            }
            if (json.has("productionCompanies")) {
                excludeFields.add("productionCompanies");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.MovieDetailsRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.MovieDetails.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MovieDetailsRealmProxy) realm.createObjectInternal(org.snowcorp.app.model.MovieDetails.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("adult")) {
            if (json.isNull("adult")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$adult(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$adult((boolean) json.getBoolean("adult"));
            }
        }
        if (json.has("backdropPath")) {
            if (json.isNull("backdropPath")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$backdropPath(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$backdropPath((String) json.getString("backdropPath"));
            }
        }
        if (json.has("belongsToCollection")) {
            if (json.isNull("belongsToCollection")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$belongsToCollection(null);
            } else {
                org.snowcorp.app.model.BelongsToCollection belongsToCollectionObj = BelongsToCollectionRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("belongsToCollection"), update);
                ((MovieDetailsRealmProxyInterface) obj).realmSet$belongsToCollection(belongsToCollectionObj);
            }
        }
        if (json.has("budget")) {
            if (json.isNull("budget")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$budget(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$budget((int) json.getInt("budget"));
            }
        }
        if (json.has("genres")) {
            if (json.isNull("genres")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$genres(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmGet$genres().clear();
                JSONArray array = json.getJSONArray("genres");
                for (int i = 0; i < array.length(); i++) {
                    org.snowcorp.app.model.Genre item = GenreRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((MovieDetailsRealmProxyInterface) obj).realmGet$genres().add(item);
                }
            }
        }
        if (json.has("homepage")) {
            if (json.isNull("homepage")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$homepage(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$homepage((String) json.getString("homepage"));
            }
        }
        if (json.has("imdbId")) {
            if (json.isNull("imdbId")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$imdbId(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$imdbId((String) json.getString("imdbId"));
            }
        }
        if (json.has("originalLanguage")) {
            if (json.isNull("originalLanguage")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$originalLanguage(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$originalLanguage((String) json.getString("originalLanguage"));
            }
        }
        if (json.has("originalTitle")) {
            if (json.isNull("originalTitle")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$originalTitle(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$originalTitle((String) json.getString("originalTitle"));
            }
        }
        if (json.has("overview")) {
            if (json.isNull("overview")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$overview(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$overview((String) json.getString("overview"));
            }
        }
        if (json.has("popularity")) {
            if (json.isNull("popularity")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$popularity(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$popularity((double) json.getDouble("popularity"));
            }
        }
        if (json.has("posterPath")) {
            if (json.isNull("posterPath")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$posterPath(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$posterPath((String) json.getString("posterPath"));
            }
        }
        if (json.has("productionCompanies")) {
            if (json.isNull("productionCompanies")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$productionCompanies(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmGet$productionCompanies().clear();
                JSONArray array = json.getJSONArray("productionCompanies");
                for (int i = 0; i < array.length(); i++) {
                    org.snowcorp.app.model.ProductionCompany item = ProductionCompanyRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((MovieDetailsRealmProxyInterface) obj).realmGet$productionCompanies().add(item);
                }
            }
        }
        if (json.has("releaseDate")) {
            if (json.isNull("releaseDate")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$releaseDate(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$releaseDate((String) json.getString("releaseDate"));
            }
        }
        if (json.has("revenue")) {
            if (json.isNull("revenue")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$revenue(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$revenue((int) json.getInt("revenue"));
            }
        }
        if (json.has("runtime")) {
            if (json.isNull("runtime")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$runtime(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$runtime((int) json.getInt("runtime"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$status(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("tagline")) {
            if (json.isNull("tagline")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$tagline(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$tagline((String) json.getString("tagline"));
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("video")) {
            if (json.isNull("video")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$video(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$video((boolean) json.getBoolean("video"));
            }
        }
        if (json.has("voteAverage")) {
            if (json.isNull("voteAverage")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$voteAverage(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$voteAverage((double) json.getDouble("voteAverage"));
            }
        }
        if (json.has("voteCount")) {
            if (json.isNull("voteCount")) {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$voteCount(null);
            } else {
                ((MovieDetailsRealmProxyInterface) obj).realmSet$voteCount((int) json.getInt("voteCount"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static org.snowcorp.app.model.MovieDetails createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        org.snowcorp.app.model.MovieDetails obj = new org.snowcorp.app.model.MovieDetails();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("adult")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$adult(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$adult((boolean) reader.nextBoolean());
                }
            } else if (name.equals("backdropPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$backdropPath(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$backdropPath((String) reader.nextString());
                }
            } else if (name.equals("belongsToCollection")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$belongsToCollection(null);
                } else {
                    org.snowcorp.app.model.BelongsToCollection belongsToCollectionObj = BelongsToCollectionRealmProxy.createUsingJsonStream(realm, reader);
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$belongsToCollection(belongsToCollectionObj);
                }
            } else if (name.equals("budget")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$budget(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$budget((int) reader.nextInt());
                }
            } else if (name.equals("genres")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$genres(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$genres(new RealmList<org.snowcorp.app.model.Genre>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        org.snowcorp.app.model.Genre item = GenreRealmProxy.createUsingJsonStream(realm, reader);
                        ((MovieDetailsRealmProxyInterface) obj).realmGet$genres().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("homepage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$homepage(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$homepage((String) reader.nextString());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("imdbId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$imdbId(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$imdbId((String) reader.nextString());
                }
            } else if (name.equals("originalLanguage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$originalLanguage(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$originalLanguage((String) reader.nextString());
                }
            } else if (name.equals("originalTitle")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$originalTitle(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$originalTitle((String) reader.nextString());
                }
            } else if (name.equals("overview")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$overview(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$overview((String) reader.nextString());
                }
            } else if (name.equals("popularity")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$popularity(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$popularity((double) reader.nextDouble());
                }
            } else if (name.equals("posterPath")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$posterPath(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$posterPath((String) reader.nextString());
                }
            } else if (name.equals("productionCompanies")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$productionCompanies(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$productionCompanies(new RealmList<org.snowcorp.app.model.ProductionCompany>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        org.snowcorp.app.model.ProductionCompany item = ProductionCompanyRealmProxy.createUsingJsonStream(realm, reader);
                        ((MovieDetailsRealmProxyInterface) obj).realmGet$productionCompanies().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("releaseDate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$releaseDate(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$releaseDate((String) reader.nextString());
                }
            } else if (name.equals("revenue")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$revenue(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$revenue((int) reader.nextInt());
                }
            } else if (name.equals("runtime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$runtime(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$runtime((int) reader.nextInt());
                }
            } else if (name.equals("status")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$status(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$status((String) reader.nextString());
                }
            } else if (name.equals("tagline")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$tagline(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$tagline((String) reader.nextString());
                }
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("video")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$video(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$video((boolean) reader.nextBoolean());
                }
            } else if (name.equals("voteAverage")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$voteAverage(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$voteAverage((double) reader.nextDouble());
                }
            } else if (name.equals("voteCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$voteCount(null);
                } else {
                    ((MovieDetailsRealmProxyInterface) obj).realmSet$voteCount((int) reader.nextInt());
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

    public static org.snowcorp.app.model.MovieDetails copyOrUpdate(Realm realm, org.snowcorp.app.model.MovieDetails object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.MovieDetails) cachedRealmObject;
        } else {
            org.snowcorp.app.model.MovieDetails realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(org.snowcorp.app.model.MovieDetails.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((MovieDetailsRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(org.snowcorp.app.model.MovieDetails.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MovieDetailsRealmProxy();
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

    public static org.snowcorp.app.model.MovieDetails copy(Realm realm, org.snowcorp.app.model.MovieDetails newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (org.snowcorp.app.model.MovieDetails) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            org.snowcorp.app.model.MovieDetails realmObject = realm.createObjectInternal(org.snowcorp.app.model.MovieDetails.class, ((MovieDetailsRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$adult(((MovieDetailsRealmProxyInterface) newObject).realmGet$adult());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$backdropPath(((MovieDetailsRealmProxyInterface) newObject).realmGet$backdropPath());

            org.snowcorp.app.model.BelongsToCollection belongsToCollectionObj = ((MovieDetailsRealmProxyInterface) newObject).realmGet$belongsToCollection();
            if (belongsToCollectionObj != null) {
                org.snowcorp.app.model.BelongsToCollection cachebelongsToCollection = (org.snowcorp.app.model.BelongsToCollection) cache.get(belongsToCollectionObj);
                if (cachebelongsToCollection != null) {
                    ((MovieDetailsRealmProxyInterface) realmObject).realmSet$belongsToCollection(cachebelongsToCollection);
                } else {
                    ((MovieDetailsRealmProxyInterface) realmObject).realmSet$belongsToCollection(BelongsToCollectionRealmProxy.copyOrUpdate(realm, belongsToCollectionObj, update, cache));
                }
            } else {
                ((MovieDetailsRealmProxyInterface) realmObject).realmSet$belongsToCollection(null);
            }
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$budget(((MovieDetailsRealmProxyInterface) newObject).realmGet$budget());

            RealmList<org.snowcorp.app.model.Genre> genresList = ((MovieDetailsRealmProxyInterface) newObject).realmGet$genres();
            if (genresList != null) {
                RealmList<org.snowcorp.app.model.Genre> genresRealmList = ((MovieDetailsRealmProxyInterface) realmObject).realmGet$genres();
                for (int i = 0; i < genresList.size(); i++) {
                    org.snowcorp.app.model.Genre genresItem = genresList.get(i);
                    org.snowcorp.app.model.Genre cachegenres = (org.snowcorp.app.model.Genre) cache.get(genresItem);
                    if (cachegenres != null) {
                        genresRealmList.add(cachegenres);
                    } else {
                        genresRealmList.add(GenreRealmProxy.copyOrUpdate(realm, genresList.get(i), update, cache));
                    }
                }
            }

            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$homepage(((MovieDetailsRealmProxyInterface) newObject).realmGet$homepage());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$imdbId(((MovieDetailsRealmProxyInterface) newObject).realmGet$imdbId());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$originalLanguage(((MovieDetailsRealmProxyInterface) newObject).realmGet$originalLanguage());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$originalTitle(((MovieDetailsRealmProxyInterface) newObject).realmGet$originalTitle());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$overview(((MovieDetailsRealmProxyInterface) newObject).realmGet$overview());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$popularity(((MovieDetailsRealmProxyInterface) newObject).realmGet$popularity());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$posterPath(((MovieDetailsRealmProxyInterface) newObject).realmGet$posterPath());

            RealmList<org.snowcorp.app.model.ProductionCompany> productionCompaniesList = ((MovieDetailsRealmProxyInterface) newObject).realmGet$productionCompanies();
            if (productionCompaniesList != null) {
                RealmList<org.snowcorp.app.model.ProductionCompany> productionCompaniesRealmList = ((MovieDetailsRealmProxyInterface) realmObject).realmGet$productionCompanies();
                for (int i = 0; i < productionCompaniesList.size(); i++) {
                    org.snowcorp.app.model.ProductionCompany productionCompaniesItem = productionCompaniesList.get(i);
                    org.snowcorp.app.model.ProductionCompany cacheproductionCompanies = (org.snowcorp.app.model.ProductionCompany) cache.get(productionCompaniesItem);
                    if (cacheproductionCompanies != null) {
                        productionCompaniesRealmList.add(cacheproductionCompanies);
                    } else {
                        productionCompaniesRealmList.add(ProductionCompanyRealmProxy.copyOrUpdate(realm, productionCompaniesList.get(i), update, cache));
                    }
                }
            }

            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$releaseDate(((MovieDetailsRealmProxyInterface) newObject).realmGet$releaseDate());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$revenue(((MovieDetailsRealmProxyInterface) newObject).realmGet$revenue());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$runtime(((MovieDetailsRealmProxyInterface) newObject).realmGet$runtime());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$status(((MovieDetailsRealmProxyInterface) newObject).realmGet$status());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$tagline(((MovieDetailsRealmProxyInterface) newObject).realmGet$tagline());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$title(((MovieDetailsRealmProxyInterface) newObject).realmGet$title());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$video(((MovieDetailsRealmProxyInterface) newObject).realmGet$video());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$voteAverage(((MovieDetailsRealmProxyInterface) newObject).realmGet$voteAverage());
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$voteCount(((MovieDetailsRealmProxyInterface) newObject).realmGet$voteCount());
            return realmObject;
        }
    }

    public static long insert(Realm realm, org.snowcorp.app.model.MovieDetails object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.MovieDetails.class);
        long tableNativePtr = table.getNativePtr();
        MovieDetailsColumnInfo columnInfo = (MovieDetailsColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.MovieDetails.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((MovieDetailsRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieDetailsRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieDetailsRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Boolean realmGet$adult = ((MovieDetailsRealmProxyInterface)object).realmGet$adult();
        if (realmGet$adult != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
        }
        String realmGet$backdropPath = ((MovieDetailsRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        }

        org.snowcorp.app.model.BelongsToCollection belongsToCollectionObj = ((MovieDetailsRealmProxyInterface) object).realmGet$belongsToCollection();
        if (belongsToCollectionObj != null) {
            Long cachebelongsToCollection = cache.get(belongsToCollectionObj);
            if (cachebelongsToCollection == null) {
                cachebelongsToCollection = BelongsToCollectionRealmProxy.insert(realm, belongsToCollectionObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.belongsToCollectionIndex, rowIndex, cachebelongsToCollection, false);
        }
        Number realmGet$budget = ((MovieDetailsRealmProxyInterface)object).realmGet$budget();
        if (realmGet$budget != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.budgetIndex, rowIndex, realmGet$budget.longValue(), false);
        }

        RealmList<org.snowcorp.app.model.Genre> genresList = ((MovieDetailsRealmProxyInterface) object).realmGet$genres();
        if (genresList != null) {
            long genresNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.genresIndex, rowIndex);
            for (org.snowcorp.app.model.Genre genresItem : genresList) {
                Long cacheItemIndexgenres = cache.get(genresItem);
                if (cacheItemIndexgenres == null) {
                    cacheItemIndexgenres = GenreRealmProxy.insert(realm, genresItem, cache);
                }
                LinkView.nativeAdd(genresNativeLinkViewPtr, cacheItemIndexgenres);
            }
        }

        String realmGet$homepage = ((MovieDetailsRealmProxyInterface)object).realmGet$homepage();
        if (realmGet$homepage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
        }
        String realmGet$imdbId = ((MovieDetailsRealmProxyInterface)object).realmGet$imdbId();
        if (realmGet$imdbId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, realmGet$imdbId, false);
        }
        String realmGet$originalLanguage = ((MovieDetailsRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        }
        String realmGet$originalTitle = ((MovieDetailsRealmProxyInterface)object).realmGet$originalTitle();
        if (realmGet$originalTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
        }
        String realmGet$overview = ((MovieDetailsRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        }
        Double realmGet$popularity = ((MovieDetailsRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        }
        String realmGet$posterPath = ((MovieDetailsRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        }

        RealmList<org.snowcorp.app.model.ProductionCompany> productionCompaniesList = ((MovieDetailsRealmProxyInterface) object).realmGet$productionCompanies();
        if (productionCompaniesList != null) {
            long productionCompaniesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCompaniesIndex, rowIndex);
            for (org.snowcorp.app.model.ProductionCompany productionCompaniesItem : productionCompaniesList) {
                Long cacheItemIndexproductionCompanies = cache.get(productionCompaniesItem);
                if (cacheItemIndexproductionCompanies == null) {
                    cacheItemIndexproductionCompanies = ProductionCompanyRealmProxy.insert(realm, productionCompaniesItem, cache);
                }
                LinkView.nativeAdd(productionCompaniesNativeLinkViewPtr, cacheItemIndexproductionCompanies);
            }
        }

        String realmGet$releaseDate = ((MovieDetailsRealmProxyInterface)object).realmGet$releaseDate();
        if (realmGet$releaseDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
        }
        Number realmGet$revenue = ((MovieDetailsRealmProxyInterface)object).realmGet$revenue();
        if (realmGet$revenue != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.revenueIndex, rowIndex, realmGet$revenue.longValue(), false);
        }
        Number realmGet$runtime = ((MovieDetailsRealmProxyInterface)object).realmGet$runtime();
        if (realmGet$runtime != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.runtimeIndex, rowIndex, realmGet$runtime.longValue(), false);
        }
        String realmGet$status = ((MovieDetailsRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        String realmGet$tagline = ((MovieDetailsRealmProxyInterface)object).realmGet$tagline();
        if (realmGet$tagline != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.taglineIndex, rowIndex, realmGet$tagline, false);
        }
        String realmGet$title = ((MovieDetailsRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        Boolean realmGet$video = ((MovieDetailsRealmProxyInterface)object).realmGet$video();
        if (realmGet$video != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
        }
        Double realmGet$voteAverage = ((MovieDetailsRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        }
        Number realmGet$voteCount = ((MovieDetailsRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.MovieDetails.class);
        long tableNativePtr = table.getNativePtr();
        MovieDetailsColumnInfo columnInfo = (MovieDetailsColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.MovieDetails.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.MovieDetails object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.MovieDetails) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((MovieDetailsRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieDetailsRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieDetailsRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Boolean realmGet$adult = ((MovieDetailsRealmProxyInterface)object).realmGet$adult();
                if (realmGet$adult != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
                }
                String realmGet$backdropPath = ((MovieDetailsRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                }

                org.snowcorp.app.model.BelongsToCollection belongsToCollectionObj = ((MovieDetailsRealmProxyInterface) object).realmGet$belongsToCollection();
                if (belongsToCollectionObj != null) {
                    Long cachebelongsToCollection = cache.get(belongsToCollectionObj);
                    if (cachebelongsToCollection == null) {
                        cachebelongsToCollection = BelongsToCollectionRealmProxy.insert(realm, belongsToCollectionObj, cache);
                    }
                    table.setLink(columnInfo.belongsToCollectionIndex, rowIndex, cachebelongsToCollection, false);
                }
                Number realmGet$budget = ((MovieDetailsRealmProxyInterface)object).realmGet$budget();
                if (realmGet$budget != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.budgetIndex, rowIndex, realmGet$budget.longValue(), false);
                }

                RealmList<org.snowcorp.app.model.Genre> genresList = ((MovieDetailsRealmProxyInterface) object).realmGet$genres();
                if (genresList != null) {
                    long genresNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.genresIndex, rowIndex);
                    for (org.snowcorp.app.model.Genre genresItem : genresList) {
                        Long cacheItemIndexgenres = cache.get(genresItem);
                        if (cacheItemIndexgenres == null) {
                            cacheItemIndexgenres = GenreRealmProxy.insert(realm, genresItem, cache);
                        }
                        LinkView.nativeAdd(genresNativeLinkViewPtr, cacheItemIndexgenres);
                    }
                }

                String realmGet$homepage = ((MovieDetailsRealmProxyInterface)object).realmGet$homepage();
                if (realmGet$homepage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
                }
                String realmGet$imdbId = ((MovieDetailsRealmProxyInterface)object).realmGet$imdbId();
                if (realmGet$imdbId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, realmGet$imdbId, false);
                }
                String realmGet$originalLanguage = ((MovieDetailsRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                }
                String realmGet$originalTitle = ((MovieDetailsRealmProxyInterface)object).realmGet$originalTitle();
                if (realmGet$originalTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
                }
                String realmGet$overview = ((MovieDetailsRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                }
                Double realmGet$popularity = ((MovieDetailsRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                }
                String realmGet$posterPath = ((MovieDetailsRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                }

                RealmList<org.snowcorp.app.model.ProductionCompany> productionCompaniesList = ((MovieDetailsRealmProxyInterface) object).realmGet$productionCompanies();
                if (productionCompaniesList != null) {
                    long productionCompaniesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCompaniesIndex, rowIndex);
                    for (org.snowcorp.app.model.ProductionCompany productionCompaniesItem : productionCompaniesList) {
                        Long cacheItemIndexproductionCompanies = cache.get(productionCompaniesItem);
                        if (cacheItemIndexproductionCompanies == null) {
                            cacheItemIndexproductionCompanies = ProductionCompanyRealmProxy.insert(realm, productionCompaniesItem, cache);
                        }
                        LinkView.nativeAdd(productionCompaniesNativeLinkViewPtr, cacheItemIndexproductionCompanies);
                    }
                }

                String realmGet$releaseDate = ((MovieDetailsRealmProxyInterface)object).realmGet$releaseDate();
                if (realmGet$releaseDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
                }
                Number realmGet$revenue = ((MovieDetailsRealmProxyInterface)object).realmGet$revenue();
                if (realmGet$revenue != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.revenueIndex, rowIndex, realmGet$revenue.longValue(), false);
                }
                Number realmGet$runtime = ((MovieDetailsRealmProxyInterface)object).realmGet$runtime();
                if (realmGet$runtime != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.runtimeIndex, rowIndex, realmGet$runtime.longValue(), false);
                }
                String realmGet$status = ((MovieDetailsRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                }
                String realmGet$tagline = ((MovieDetailsRealmProxyInterface)object).realmGet$tagline();
                if (realmGet$tagline != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.taglineIndex, rowIndex, realmGet$tagline, false);
                }
                String realmGet$title = ((MovieDetailsRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                Boolean realmGet$video = ((MovieDetailsRealmProxyInterface)object).realmGet$video();
                if (realmGet$video != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
                }
                Double realmGet$voteAverage = ((MovieDetailsRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                }
                Number realmGet$voteCount = ((MovieDetailsRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, org.snowcorp.app.model.MovieDetails object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(org.snowcorp.app.model.MovieDetails.class);
        long tableNativePtr = table.getNativePtr();
        MovieDetailsColumnInfo columnInfo = (MovieDetailsColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.MovieDetails.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((MovieDetailsRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieDetailsRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieDetailsRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Boolean realmGet$adult = ((MovieDetailsRealmProxyInterface)object).realmGet$adult();
        if (realmGet$adult != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.adultIndex, rowIndex, false);
        }
        String realmGet$backdropPath = ((MovieDetailsRealmProxyInterface)object).realmGet$backdropPath();
        if (realmGet$backdropPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
        }

        org.snowcorp.app.model.BelongsToCollection belongsToCollectionObj = ((MovieDetailsRealmProxyInterface) object).realmGet$belongsToCollection();
        if (belongsToCollectionObj != null) {
            Long cachebelongsToCollection = cache.get(belongsToCollectionObj);
            if (cachebelongsToCollection == null) {
                cachebelongsToCollection = BelongsToCollectionRealmProxy.insertOrUpdate(realm, belongsToCollectionObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.belongsToCollectionIndex, rowIndex, cachebelongsToCollection, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.belongsToCollectionIndex, rowIndex);
        }
        Number realmGet$budget = ((MovieDetailsRealmProxyInterface)object).realmGet$budget();
        if (realmGet$budget != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.budgetIndex, rowIndex, realmGet$budget.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.budgetIndex, rowIndex, false);
        }

        long genresNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.genresIndex, rowIndex);
        LinkView.nativeClear(genresNativeLinkViewPtr);
        RealmList<org.snowcorp.app.model.Genre> genresList = ((MovieDetailsRealmProxyInterface) object).realmGet$genres();
        if (genresList != null) {
            for (org.snowcorp.app.model.Genre genresItem : genresList) {
                Long cacheItemIndexgenres = cache.get(genresItem);
                if (cacheItemIndexgenres == null) {
                    cacheItemIndexgenres = GenreRealmProxy.insertOrUpdate(realm, genresItem, cache);
                }
                LinkView.nativeAdd(genresNativeLinkViewPtr, cacheItemIndexgenres);
            }
        }

        String realmGet$homepage = ((MovieDetailsRealmProxyInterface)object).realmGet$homepage();
        if (realmGet$homepage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.homepageIndex, rowIndex, false);
        }
        String realmGet$imdbId = ((MovieDetailsRealmProxyInterface)object).realmGet$imdbId();
        if (realmGet$imdbId != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, realmGet$imdbId, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, false);
        }
        String realmGet$originalLanguage = ((MovieDetailsRealmProxyInterface)object).realmGet$originalLanguage();
        if (realmGet$originalLanguage != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
        }
        String realmGet$originalTitle = ((MovieDetailsRealmProxyInterface)object).realmGet$originalTitle();
        if (realmGet$originalTitle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, false);
        }
        String realmGet$overview = ((MovieDetailsRealmProxyInterface)object).realmGet$overview();
        if (realmGet$overview != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
        }
        Double realmGet$popularity = ((MovieDetailsRealmProxyInterface)object).realmGet$popularity();
        if (realmGet$popularity != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
        }
        String realmGet$posterPath = ((MovieDetailsRealmProxyInterface)object).realmGet$posterPath();
        if (realmGet$posterPath != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
        }

        long productionCompaniesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCompaniesIndex, rowIndex);
        LinkView.nativeClear(productionCompaniesNativeLinkViewPtr);
        RealmList<org.snowcorp.app.model.ProductionCompany> productionCompaniesList = ((MovieDetailsRealmProxyInterface) object).realmGet$productionCompanies();
        if (productionCompaniesList != null) {
            for (org.snowcorp.app.model.ProductionCompany productionCompaniesItem : productionCompaniesList) {
                Long cacheItemIndexproductionCompanies = cache.get(productionCompaniesItem);
                if (cacheItemIndexproductionCompanies == null) {
                    cacheItemIndexproductionCompanies = ProductionCompanyRealmProxy.insertOrUpdate(realm, productionCompaniesItem, cache);
                }
                LinkView.nativeAdd(productionCompaniesNativeLinkViewPtr, cacheItemIndexproductionCompanies);
            }
        }

        String realmGet$releaseDate = ((MovieDetailsRealmProxyInterface)object).realmGet$releaseDate();
        if (realmGet$releaseDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, false);
        }
        Number realmGet$revenue = ((MovieDetailsRealmProxyInterface)object).realmGet$revenue();
        if (realmGet$revenue != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.revenueIndex, rowIndex, realmGet$revenue.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.revenueIndex, rowIndex, false);
        }
        Number realmGet$runtime = ((MovieDetailsRealmProxyInterface)object).realmGet$runtime();
        if (realmGet$runtime != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.runtimeIndex, rowIndex, realmGet$runtime.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.runtimeIndex, rowIndex, false);
        }
        String realmGet$status = ((MovieDetailsRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        String realmGet$tagline = ((MovieDetailsRealmProxyInterface)object).realmGet$tagline();
        if (realmGet$tagline != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.taglineIndex, rowIndex, realmGet$tagline, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.taglineIndex, rowIndex, false);
        }
        String realmGet$title = ((MovieDetailsRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        Boolean realmGet$video = ((MovieDetailsRealmProxyInterface)object).realmGet$video();
        if (realmGet$video != null) {
            Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.videoIndex, rowIndex, false);
        }
        Double realmGet$voteAverage = ((MovieDetailsRealmProxyInterface)object).realmGet$voteAverage();
        if (realmGet$voteAverage != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
        }
        Number realmGet$voteCount = ((MovieDetailsRealmProxyInterface)object).realmGet$voteCount();
        if (realmGet$voteCount != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(org.snowcorp.app.model.MovieDetails.class);
        long tableNativePtr = table.getNativePtr();
        MovieDetailsColumnInfo columnInfo = (MovieDetailsColumnInfo) realm.schema.getColumnInfo(org.snowcorp.app.model.MovieDetails.class);
        long pkColumnIndex = table.getPrimaryKey();
        org.snowcorp.app.model.MovieDetails object = null;
        while (objects.hasNext()) {
            object = (org.snowcorp.app.model.MovieDetails) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((MovieDetailsRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MovieDetailsRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MovieDetailsRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                Boolean realmGet$adult = ((MovieDetailsRealmProxyInterface)object).realmGet$adult();
                if (realmGet$adult != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.adultIndex, rowIndex, realmGet$adult, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.adultIndex, rowIndex, false);
                }
                String realmGet$backdropPath = ((MovieDetailsRealmProxyInterface)object).realmGet$backdropPath();
                if (realmGet$backdropPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, realmGet$backdropPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.backdropPathIndex, rowIndex, false);
                }

                org.snowcorp.app.model.BelongsToCollection belongsToCollectionObj = ((MovieDetailsRealmProxyInterface) object).realmGet$belongsToCollection();
                if (belongsToCollectionObj != null) {
                    Long cachebelongsToCollection = cache.get(belongsToCollectionObj);
                    if (cachebelongsToCollection == null) {
                        cachebelongsToCollection = BelongsToCollectionRealmProxy.insertOrUpdate(realm, belongsToCollectionObj, cache);
                    }
                    Table.nativeSetLink(tableNativePtr, columnInfo.belongsToCollectionIndex, rowIndex, cachebelongsToCollection, false);
                } else {
                    Table.nativeNullifyLink(tableNativePtr, columnInfo.belongsToCollectionIndex, rowIndex);
                }
                Number realmGet$budget = ((MovieDetailsRealmProxyInterface)object).realmGet$budget();
                if (realmGet$budget != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.budgetIndex, rowIndex, realmGet$budget.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.budgetIndex, rowIndex, false);
                }

                long genresNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.genresIndex, rowIndex);
                LinkView.nativeClear(genresNativeLinkViewPtr);
                RealmList<org.snowcorp.app.model.Genre> genresList = ((MovieDetailsRealmProxyInterface) object).realmGet$genres();
                if (genresList != null) {
                    for (org.snowcorp.app.model.Genre genresItem : genresList) {
                        Long cacheItemIndexgenres = cache.get(genresItem);
                        if (cacheItemIndexgenres == null) {
                            cacheItemIndexgenres = GenreRealmProxy.insertOrUpdate(realm, genresItem, cache);
                        }
                        LinkView.nativeAdd(genresNativeLinkViewPtr, cacheItemIndexgenres);
                    }
                }

                String realmGet$homepage = ((MovieDetailsRealmProxyInterface)object).realmGet$homepage();
                if (realmGet$homepage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.homepageIndex, rowIndex, realmGet$homepage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.homepageIndex, rowIndex, false);
                }
                String realmGet$imdbId = ((MovieDetailsRealmProxyInterface)object).realmGet$imdbId();
                if (realmGet$imdbId != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, realmGet$imdbId, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.imdbIdIndex, rowIndex, false);
                }
                String realmGet$originalLanguage = ((MovieDetailsRealmProxyInterface)object).realmGet$originalLanguage();
                if (realmGet$originalLanguage != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, realmGet$originalLanguage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalLanguageIndex, rowIndex, false);
                }
                String realmGet$originalTitle = ((MovieDetailsRealmProxyInterface)object).realmGet$originalTitle();
                if (realmGet$originalTitle != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, realmGet$originalTitle, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.originalTitleIndex, rowIndex, false);
                }
                String realmGet$overview = ((MovieDetailsRealmProxyInterface)object).realmGet$overview();
                if (realmGet$overview != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.overviewIndex, rowIndex, realmGet$overview, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.overviewIndex, rowIndex, false);
                }
                Double realmGet$popularity = ((MovieDetailsRealmProxyInterface)object).realmGet$popularity();
                if (realmGet$popularity != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.popularityIndex, rowIndex, realmGet$popularity, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.popularityIndex, rowIndex, false);
                }
                String realmGet$posterPath = ((MovieDetailsRealmProxyInterface)object).realmGet$posterPath();
                if (realmGet$posterPath != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.posterPathIndex, rowIndex, realmGet$posterPath, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.posterPathIndex, rowIndex, false);
                }

                long productionCompaniesNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productionCompaniesIndex, rowIndex);
                LinkView.nativeClear(productionCompaniesNativeLinkViewPtr);
                RealmList<org.snowcorp.app.model.ProductionCompany> productionCompaniesList = ((MovieDetailsRealmProxyInterface) object).realmGet$productionCompanies();
                if (productionCompaniesList != null) {
                    for (org.snowcorp.app.model.ProductionCompany productionCompaniesItem : productionCompaniesList) {
                        Long cacheItemIndexproductionCompanies = cache.get(productionCompaniesItem);
                        if (cacheItemIndexproductionCompanies == null) {
                            cacheItemIndexproductionCompanies = ProductionCompanyRealmProxy.insertOrUpdate(realm, productionCompaniesItem, cache);
                        }
                        LinkView.nativeAdd(productionCompaniesNativeLinkViewPtr, cacheItemIndexproductionCompanies);
                    }
                }

                String realmGet$releaseDate = ((MovieDetailsRealmProxyInterface)object).realmGet$releaseDate();
                if (realmGet$releaseDate != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, realmGet$releaseDate, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.releaseDateIndex, rowIndex, false);
                }
                Number realmGet$revenue = ((MovieDetailsRealmProxyInterface)object).realmGet$revenue();
                if (realmGet$revenue != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.revenueIndex, rowIndex, realmGet$revenue.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.revenueIndex, rowIndex, false);
                }
                Number realmGet$runtime = ((MovieDetailsRealmProxyInterface)object).realmGet$runtime();
                if (realmGet$runtime != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.runtimeIndex, rowIndex, realmGet$runtime.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.runtimeIndex, rowIndex, false);
                }
                String realmGet$status = ((MovieDetailsRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
                }
                String realmGet$tagline = ((MovieDetailsRealmProxyInterface)object).realmGet$tagline();
                if (realmGet$tagline != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.taglineIndex, rowIndex, realmGet$tagline, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.taglineIndex, rowIndex, false);
                }
                String realmGet$title = ((MovieDetailsRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                Boolean realmGet$video = ((MovieDetailsRealmProxyInterface)object).realmGet$video();
                if (realmGet$video != null) {
                    Table.nativeSetBoolean(tableNativePtr, columnInfo.videoIndex, rowIndex, realmGet$video, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.videoIndex, rowIndex, false);
                }
                Double realmGet$voteAverage = ((MovieDetailsRealmProxyInterface)object).realmGet$voteAverage();
                if (realmGet$voteAverage != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, realmGet$voteAverage, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteAverageIndex, rowIndex, false);
                }
                Number realmGet$voteCount = ((MovieDetailsRealmProxyInterface)object).realmGet$voteCount();
                if (realmGet$voteCount != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.voteCountIndex, rowIndex, realmGet$voteCount.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voteCountIndex, rowIndex, false);
                }
            }
        }
    }

    public static org.snowcorp.app.model.MovieDetails createDetachedCopy(org.snowcorp.app.model.MovieDetails realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        org.snowcorp.app.model.MovieDetails unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (org.snowcorp.app.model.MovieDetails)cachedObject.object;
            } else {
                unmanagedObject = (org.snowcorp.app.model.MovieDetails)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new org.snowcorp.app.model.MovieDetails();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$adult(((MovieDetailsRealmProxyInterface) realmObject).realmGet$adult());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$backdropPath(((MovieDetailsRealmProxyInterface) realmObject).realmGet$backdropPath());

        // Deep copy of belongsToCollection
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$belongsToCollection(BelongsToCollectionRealmProxy.createDetachedCopy(((MovieDetailsRealmProxyInterface) realmObject).realmGet$belongsToCollection(), currentDepth + 1, maxDepth, cache));
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$budget(((MovieDetailsRealmProxyInterface) realmObject).realmGet$budget());

        // Deep copy of genres
        if (currentDepth == maxDepth) {
            ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$genres(null);
        } else {
            RealmList<org.snowcorp.app.model.Genre> managedgenresList = ((MovieDetailsRealmProxyInterface) realmObject).realmGet$genres();
            RealmList<org.snowcorp.app.model.Genre> unmanagedgenresList = new RealmList<org.snowcorp.app.model.Genre>();
            ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$genres(unmanagedgenresList);
            int nextDepth = currentDepth + 1;
            int size = managedgenresList.size();
            for (int i = 0; i < size; i++) {
                org.snowcorp.app.model.Genre item = GenreRealmProxy.createDetachedCopy(managedgenresList.get(i), nextDepth, maxDepth, cache);
                unmanagedgenresList.add(item);
            }
        }
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$homepage(((MovieDetailsRealmProxyInterface) realmObject).realmGet$homepage());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$id(((MovieDetailsRealmProxyInterface) realmObject).realmGet$id());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$imdbId(((MovieDetailsRealmProxyInterface) realmObject).realmGet$imdbId());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$originalLanguage(((MovieDetailsRealmProxyInterface) realmObject).realmGet$originalLanguage());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$originalTitle(((MovieDetailsRealmProxyInterface) realmObject).realmGet$originalTitle());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$overview(((MovieDetailsRealmProxyInterface) realmObject).realmGet$overview());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$popularity(((MovieDetailsRealmProxyInterface) realmObject).realmGet$popularity());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$posterPath(((MovieDetailsRealmProxyInterface) realmObject).realmGet$posterPath());

        // Deep copy of productionCompanies
        if (currentDepth == maxDepth) {
            ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$productionCompanies(null);
        } else {
            RealmList<org.snowcorp.app.model.ProductionCompany> managedproductionCompaniesList = ((MovieDetailsRealmProxyInterface) realmObject).realmGet$productionCompanies();
            RealmList<org.snowcorp.app.model.ProductionCompany> unmanagedproductionCompaniesList = new RealmList<org.snowcorp.app.model.ProductionCompany>();
            ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$productionCompanies(unmanagedproductionCompaniesList);
            int nextDepth = currentDepth + 1;
            int size = managedproductionCompaniesList.size();
            for (int i = 0; i < size; i++) {
                org.snowcorp.app.model.ProductionCompany item = ProductionCompanyRealmProxy.createDetachedCopy(managedproductionCompaniesList.get(i), nextDepth, maxDepth, cache);
                unmanagedproductionCompaniesList.add(item);
            }
        }
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$releaseDate(((MovieDetailsRealmProxyInterface) realmObject).realmGet$releaseDate());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$revenue(((MovieDetailsRealmProxyInterface) realmObject).realmGet$revenue());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$runtime(((MovieDetailsRealmProxyInterface) realmObject).realmGet$runtime());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$status(((MovieDetailsRealmProxyInterface) realmObject).realmGet$status());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$tagline(((MovieDetailsRealmProxyInterface) realmObject).realmGet$tagline());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$title(((MovieDetailsRealmProxyInterface) realmObject).realmGet$title());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$video(((MovieDetailsRealmProxyInterface) realmObject).realmGet$video());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$voteAverage(((MovieDetailsRealmProxyInterface) realmObject).realmGet$voteAverage());
        ((MovieDetailsRealmProxyInterface) unmanagedObject).realmSet$voteCount(((MovieDetailsRealmProxyInterface) realmObject).realmGet$voteCount());
        return unmanagedObject;
    }

    static org.snowcorp.app.model.MovieDetails update(Realm realm, org.snowcorp.app.model.MovieDetails realmObject, org.snowcorp.app.model.MovieDetails newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$adult(((MovieDetailsRealmProxyInterface) newObject).realmGet$adult());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$backdropPath(((MovieDetailsRealmProxyInterface) newObject).realmGet$backdropPath());
        org.snowcorp.app.model.BelongsToCollection belongsToCollectionObj = ((MovieDetailsRealmProxyInterface) newObject).realmGet$belongsToCollection();
        if (belongsToCollectionObj != null) {
            org.snowcorp.app.model.BelongsToCollection cachebelongsToCollection = (org.snowcorp.app.model.BelongsToCollection) cache.get(belongsToCollectionObj);
            if (cachebelongsToCollection != null) {
                ((MovieDetailsRealmProxyInterface) realmObject).realmSet$belongsToCollection(cachebelongsToCollection);
            } else {
                ((MovieDetailsRealmProxyInterface) realmObject).realmSet$belongsToCollection(BelongsToCollectionRealmProxy.copyOrUpdate(realm, belongsToCollectionObj, true, cache));
            }
        } else {
            ((MovieDetailsRealmProxyInterface) realmObject).realmSet$belongsToCollection(null);
        }
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$budget(((MovieDetailsRealmProxyInterface) newObject).realmGet$budget());
        RealmList<org.snowcorp.app.model.Genre> genresList = ((MovieDetailsRealmProxyInterface) newObject).realmGet$genres();
        RealmList<org.snowcorp.app.model.Genre> genresRealmList = ((MovieDetailsRealmProxyInterface) realmObject).realmGet$genres();
        genresRealmList.clear();
        if (genresList != null) {
            for (int i = 0; i < genresList.size(); i++) {
                org.snowcorp.app.model.Genre genresItem = genresList.get(i);
                org.snowcorp.app.model.Genre cachegenres = (org.snowcorp.app.model.Genre) cache.get(genresItem);
                if (cachegenres != null) {
                    genresRealmList.add(cachegenres);
                } else {
                    genresRealmList.add(GenreRealmProxy.copyOrUpdate(realm, genresList.get(i), true, cache));
                }
            }
        }
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$homepage(((MovieDetailsRealmProxyInterface) newObject).realmGet$homepage());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$imdbId(((MovieDetailsRealmProxyInterface) newObject).realmGet$imdbId());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$originalLanguage(((MovieDetailsRealmProxyInterface) newObject).realmGet$originalLanguage());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$originalTitle(((MovieDetailsRealmProxyInterface) newObject).realmGet$originalTitle());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$overview(((MovieDetailsRealmProxyInterface) newObject).realmGet$overview());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$popularity(((MovieDetailsRealmProxyInterface) newObject).realmGet$popularity());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$posterPath(((MovieDetailsRealmProxyInterface) newObject).realmGet$posterPath());
        RealmList<org.snowcorp.app.model.ProductionCompany> productionCompaniesList = ((MovieDetailsRealmProxyInterface) newObject).realmGet$productionCompanies();
        RealmList<org.snowcorp.app.model.ProductionCompany> productionCompaniesRealmList = ((MovieDetailsRealmProxyInterface) realmObject).realmGet$productionCompanies();
        productionCompaniesRealmList.clear();
        if (productionCompaniesList != null) {
            for (int i = 0; i < productionCompaniesList.size(); i++) {
                org.snowcorp.app.model.ProductionCompany productionCompaniesItem = productionCompaniesList.get(i);
                org.snowcorp.app.model.ProductionCompany cacheproductionCompanies = (org.snowcorp.app.model.ProductionCompany) cache.get(productionCompaniesItem);
                if (cacheproductionCompanies != null) {
                    productionCompaniesRealmList.add(cacheproductionCompanies);
                } else {
                    productionCompaniesRealmList.add(ProductionCompanyRealmProxy.copyOrUpdate(realm, productionCompaniesList.get(i), true, cache));
                }
            }
        }
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$releaseDate(((MovieDetailsRealmProxyInterface) newObject).realmGet$releaseDate());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$revenue(((MovieDetailsRealmProxyInterface) newObject).realmGet$revenue());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$runtime(((MovieDetailsRealmProxyInterface) newObject).realmGet$runtime());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$status(((MovieDetailsRealmProxyInterface) newObject).realmGet$status());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$tagline(((MovieDetailsRealmProxyInterface) newObject).realmGet$tagline());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$title(((MovieDetailsRealmProxyInterface) newObject).realmGet$title());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$video(((MovieDetailsRealmProxyInterface) newObject).realmGet$video());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$voteAverage(((MovieDetailsRealmProxyInterface) newObject).realmGet$voteAverage());
        ((MovieDetailsRealmProxyInterface) realmObject).realmSet$voteCount(((MovieDetailsRealmProxyInterface) newObject).realmGet$voteCount());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MovieDetails = proxy[");
        stringBuilder.append("{adult:");
        stringBuilder.append(realmGet$adult() != null ? realmGet$adult() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{backdropPath:");
        stringBuilder.append(realmGet$backdropPath() != null ? realmGet$backdropPath() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{belongsToCollection:");
        stringBuilder.append(realmGet$belongsToCollection() != null ? "BelongsToCollection" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{budget:");
        stringBuilder.append(realmGet$budget() != null ? realmGet$budget() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{genres:");
        stringBuilder.append("RealmList<Genre>[").append(realmGet$genres().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{homepage:");
        stringBuilder.append(realmGet$homepage() != null ? realmGet$homepage() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{imdbId:");
        stringBuilder.append(realmGet$imdbId() != null ? realmGet$imdbId() : "null");
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
        stringBuilder.append("{overview:");
        stringBuilder.append(realmGet$overview() != null ? realmGet$overview() : "null");
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
        stringBuilder.append("{productionCompanies:");
        stringBuilder.append("RealmList<ProductionCompany>[").append(realmGet$productionCompanies().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{releaseDate:");
        stringBuilder.append(realmGet$releaseDate() != null ? realmGet$releaseDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{revenue:");
        stringBuilder.append(realmGet$revenue() != null ? realmGet$revenue() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{runtime:");
        stringBuilder.append(realmGet$runtime() != null ? realmGet$runtime() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tagline:");
        stringBuilder.append(realmGet$tagline() != null ? realmGet$tagline() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
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
        stringBuilder.append("{voteCount:");
        stringBuilder.append(realmGet$voteCount() != null ? realmGet$voteCount() : "null");
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
        MovieDetailsRealmProxy aMovieDetails = (MovieDetailsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMovieDetails.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMovieDetails.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMovieDetails.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
