package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(org.snowcorp.app.model.Register.class);
        modelClasses.add(org.snowcorp.app.model.BookingMovieResult.class);
        modelClasses.add(org.snowcorp.app.model.BelongsToCollection.class);
        modelClasses.add(org.snowcorp.app.model.Genre.class);
        modelClasses.add(org.snowcorp.app.model.MovieDetails.class);
        modelClasses.add(org.snowcorp.app.model.Review.class);
        modelClasses.add(org.snowcorp.app.model.Movie.class);
        modelClasses.add(org.snowcorp.app.model.ReviewResult.class);
        modelClasses.add(org.snowcorp.app.model.MovieResult.class);
        modelClasses.add(org.snowcorp.app.model.ProductionCompany.class);
        modelClasses.add(org.snowcorp.app.model.Session.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(org.snowcorp.app.model.Register.class)) {
            return io.realm.RegisterRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
            return io.realm.BookingMovieResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
            return io.realm.BelongsToCollectionRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
            return io.realm.GenreRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
            return io.realm.MovieDetailsRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(org.snowcorp.app.model.Review.class)) {
            return io.realm.ReviewRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
            return io.realm.MovieRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
            return io.realm.ReviewResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
            return io.realm.MovieResultRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
            return io.realm.ProductionCompanyRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(org.snowcorp.app.model.Session.class)) {
            return io.realm.SessionRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(org.snowcorp.app.model.Register.class)) {
            return io.realm.RegisterRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
            return io.realm.BookingMovieResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
            return io.realm.BelongsToCollectionRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
            return io.realm.GenreRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
            return io.realm.MovieDetailsRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(org.snowcorp.app.model.Review.class)) {
            return io.realm.ReviewRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
            return io.realm.MovieRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
            return io.realm.ReviewResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
            return io.realm.MovieResultRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
            return io.realm.ProductionCompanyRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(org.snowcorp.app.model.Session.class)) {
            return io.realm.SessionRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(org.snowcorp.app.model.Register.class)) {
            return io.realm.RegisterRealmProxy.getFieldNames();
        }
        if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
            return io.realm.BookingMovieResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
            return io.realm.BelongsToCollectionRealmProxy.getFieldNames();
        }
        if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
            return io.realm.GenreRealmProxy.getFieldNames();
        }
        if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
            return io.realm.MovieDetailsRealmProxy.getFieldNames();
        }
        if (clazz.equals(org.snowcorp.app.model.Review.class)) {
            return io.realm.ReviewRealmProxy.getFieldNames();
        }
        if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
            return io.realm.MovieRealmProxy.getFieldNames();
        }
        if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
            return io.realm.ReviewResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
            return io.realm.MovieResultRealmProxy.getFieldNames();
        }
        if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
            return io.realm.ProductionCompanyRealmProxy.getFieldNames();
        }
        if (clazz.equals(org.snowcorp.app.model.Session.class)) {
            return io.realm.SessionRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(org.snowcorp.app.model.Register.class)) {
            return io.realm.RegisterRealmProxy.getTableName();
        }
        if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
            return io.realm.BookingMovieResultRealmProxy.getTableName();
        }
        if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
            return io.realm.BelongsToCollectionRealmProxy.getTableName();
        }
        if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
            return io.realm.GenreRealmProxy.getTableName();
        }
        if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
            return io.realm.MovieDetailsRealmProxy.getTableName();
        }
        if (clazz.equals(org.snowcorp.app.model.Review.class)) {
            return io.realm.ReviewRealmProxy.getTableName();
        }
        if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
            return io.realm.MovieRealmProxy.getTableName();
        }
        if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
            return io.realm.ReviewResultRealmProxy.getTableName();
        }
        if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
            return io.realm.MovieResultRealmProxy.getTableName();
        }
        if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
            return io.realm.ProductionCompanyRealmProxy.getTableName();
        }
        if (clazz.equals(org.snowcorp.app.model.Session.class)) {
            return io.realm.SessionRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(org.snowcorp.app.model.Register.class)) {
                return clazz.cast(new io.realm.RegisterRealmProxy());
            }
            if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
                return clazz.cast(new io.realm.BookingMovieResultRealmProxy());
            }
            if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
                return clazz.cast(new io.realm.BelongsToCollectionRealmProxy());
            }
            if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
                return clazz.cast(new io.realm.GenreRealmProxy());
            }
            if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
                return clazz.cast(new io.realm.MovieDetailsRealmProxy());
            }
            if (clazz.equals(org.snowcorp.app.model.Review.class)) {
                return clazz.cast(new io.realm.ReviewRealmProxy());
            }
            if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
                return clazz.cast(new io.realm.MovieRealmProxy());
            }
            if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
                return clazz.cast(new io.realm.ReviewResultRealmProxy());
            }
            if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
                return clazz.cast(new io.realm.MovieResultRealmProxy());
            }
            if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
                return clazz.cast(new io.realm.ProductionCompanyRealmProxy());
            }
            if (clazz.equals(org.snowcorp.app.model.Session.class)) {
                return clazz.cast(new io.realm.SessionRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(org.snowcorp.app.model.Register.class)) {
            return clazz.cast(io.realm.RegisterRealmProxy.copyOrUpdate(realm, (org.snowcorp.app.model.Register) obj, update, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
            return clazz.cast(io.realm.BookingMovieResultRealmProxy.copyOrUpdate(realm, (org.snowcorp.app.model.BookingMovieResult) obj, update, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
            return clazz.cast(io.realm.BelongsToCollectionRealmProxy.copyOrUpdate(realm, (org.snowcorp.app.model.BelongsToCollection) obj, update, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
            return clazz.cast(io.realm.GenreRealmProxy.copyOrUpdate(realm, (org.snowcorp.app.model.Genre) obj, update, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
            return clazz.cast(io.realm.MovieDetailsRealmProxy.copyOrUpdate(realm, (org.snowcorp.app.model.MovieDetails) obj, update, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.Review.class)) {
            return clazz.cast(io.realm.ReviewRealmProxy.copyOrUpdate(realm, (org.snowcorp.app.model.Review) obj, update, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
            return clazz.cast(io.realm.MovieRealmProxy.copyOrUpdate(realm, (org.snowcorp.app.model.Movie) obj, update, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
            return clazz.cast(io.realm.ReviewResultRealmProxy.copyOrUpdate(realm, (org.snowcorp.app.model.ReviewResult) obj, update, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
            return clazz.cast(io.realm.MovieResultRealmProxy.copyOrUpdate(realm, (org.snowcorp.app.model.MovieResult) obj, update, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
            return clazz.cast(io.realm.ProductionCompanyRealmProxy.copyOrUpdate(realm, (org.snowcorp.app.model.ProductionCompany) obj, update, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.Session.class)) {
            return clazz.cast(io.realm.SessionRealmProxy.copyOrUpdate(realm, (org.snowcorp.app.model.Session) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(org.snowcorp.app.model.Register.class)) {
            io.realm.RegisterRealmProxy.insert(realm, (org.snowcorp.app.model.Register) object, cache);
        } else if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
            io.realm.BookingMovieResultRealmProxy.insert(realm, (org.snowcorp.app.model.BookingMovieResult) object, cache);
        } else if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
            io.realm.BelongsToCollectionRealmProxy.insert(realm, (org.snowcorp.app.model.BelongsToCollection) object, cache);
        } else if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
            io.realm.GenreRealmProxy.insert(realm, (org.snowcorp.app.model.Genre) object, cache);
        } else if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
            io.realm.MovieDetailsRealmProxy.insert(realm, (org.snowcorp.app.model.MovieDetails) object, cache);
        } else if (clazz.equals(org.snowcorp.app.model.Review.class)) {
            io.realm.ReviewRealmProxy.insert(realm, (org.snowcorp.app.model.Review) object, cache);
        } else if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
            io.realm.MovieRealmProxy.insert(realm, (org.snowcorp.app.model.Movie) object, cache);
        } else if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
            io.realm.ReviewResultRealmProxy.insert(realm, (org.snowcorp.app.model.ReviewResult) object, cache);
        } else if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
            io.realm.MovieResultRealmProxy.insert(realm, (org.snowcorp.app.model.MovieResult) object, cache);
        } else if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
            io.realm.ProductionCompanyRealmProxy.insert(realm, (org.snowcorp.app.model.ProductionCompany) object, cache);
        } else if (clazz.equals(org.snowcorp.app.model.Session.class)) {
            io.realm.SessionRealmProxy.insert(realm, (org.snowcorp.app.model.Session) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(org.snowcorp.app.model.Register.class)) {
                io.realm.RegisterRealmProxy.insert(realm, (org.snowcorp.app.model.Register) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
                io.realm.BookingMovieResultRealmProxy.insert(realm, (org.snowcorp.app.model.BookingMovieResult) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
                io.realm.BelongsToCollectionRealmProxy.insert(realm, (org.snowcorp.app.model.BelongsToCollection) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
                io.realm.GenreRealmProxy.insert(realm, (org.snowcorp.app.model.Genre) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
                io.realm.MovieDetailsRealmProxy.insert(realm, (org.snowcorp.app.model.MovieDetails) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.Review.class)) {
                io.realm.ReviewRealmProxy.insert(realm, (org.snowcorp.app.model.Review) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
                io.realm.MovieRealmProxy.insert(realm, (org.snowcorp.app.model.Movie) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
                io.realm.ReviewResultRealmProxy.insert(realm, (org.snowcorp.app.model.ReviewResult) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
                io.realm.MovieResultRealmProxy.insert(realm, (org.snowcorp.app.model.MovieResult) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
                io.realm.ProductionCompanyRealmProxy.insert(realm, (org.snowcorp.app.model.ProductionCompany) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.Session.class)) {
                io.realm.SessionRealmProxy.insert(realm, (org.snowcorp.app.model.Session) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(org.snowcorp.app.model.Register.class)) {
                    io.realm.RegisterRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
                    io.realm.BookingMovieResultRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
                    io.realm.BelongsToCollectionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
                    io.realm.GenreRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
                    io.realm.MovieDetailsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.Review.class)) {
                    io.realm.ReviewRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
                    io.realm.MovieRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
                    io.realm.ReviewResultRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
                    io.realm.MovieResultRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
                    io.realm.ProductionCompanyRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.Session.class)) {
                    io.realm.SessionRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(org.snowcorp.app.model.Register.class)) {
            io.realm.RegisterRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.Register) obj, cache);
        } else if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
            io.realm.BookingMovieResultRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.BookingMovieResult) obj, cache);
        } else if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
            io.realm.BelongsToCollectionRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.BelongsToCollection) obj, cache);
        } else if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
            io.realm.GenreRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.Genre) obj, cache);
        } else if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
            io.realm.MovieDetailsRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.MovieDetails) obj, cache);
        } else if (clazz.equals(org.snowcorp.app.model.Review.class)) {
            io.realm.ReviewRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.Review) obj, cache);
        } else if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
            io.realm.MovieRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.Movie) obj, cache);
        } else if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
            io.realm.ReviewResultRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.ReviewResult) obj, cache);
        } else if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
            io.realm.MovieResultRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.MovieResult) obj, cache);
        } else if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
            io.realm.ProductionCompanyRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.ProductionCompany) obj, cache);
        } else if (clazz.equals(org.snowcorp.app.model.Session.class)) {
            io.realm.SessionRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.Session) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(org.snowcorp.app.model.Register.class)) {
                io.realm.RegisterRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.Register) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
                io.realm.BookingMovieResultRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.BookingMovieResult) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
                io.realm.BelongsToCollectionRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.BelongsToCollection) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
                io.realm.GenreRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.Genre) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
                io.realm.MovieDetailsRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.MovieDetails) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.Review.class)) {
                io.realm.ReviewRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.Review) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
                io.realm.MovieRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.Movie) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
                io.realm.ReviewResultRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.ReviewResult) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
                io.realm.MovieResultRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.MovieResult) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
                io.realm.ProductionCompanyRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.ProductionCompany) object, cache);
            } else if (clazz.equals(org.snowcorp.app.model.Session.class)) {
                io.realm.SessionRealmProxy.insertOrUpdate(realm, (org.snowcorp.app.model.Session) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(org.snowcorp.app.model.Register.class)) {
                    io.realm.RegisterRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
                    io.realm.BookingMovieResultRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
                    io.realm.BelongsToCollectionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
                    io.realm.GenreRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
                    io.realm.MovieDetailsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.Review.class)) {
                    io.realm.ReviewRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
                    io.realm.MovieRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
                    io.realm.ReviewResultRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
                    io.realm.MovieResultRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
                    io.realm.ProductionCompanyRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(org.snowcorp.app.model.Session.class)) {
                    io.realm.SessionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(org.snowcorp.app.model.Register.class)) {
            return clazz.cast(io.realm.RegisterRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
            return clazz.cast(io.realm.BookingMovieResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
            return clazz.cast(io.realm.BelongsToCollectionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
            return clazz.cast(io.realm.GenreRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
            return clazz.cast(io.realm.MovieDetailsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(org.snowcorp.app.model.Review.class)) {
            return clazz.cast(io.realm.ReviewRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
            return clazz.cast(io.realm.MovieRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
            return clazz.cast(io.realm.ReviewResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
            return clazz.cast(io.realm.MovieResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
            return clazz.cast(io.realm.ProductionCompanyRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(org.snowcorp.app.model.Session.class)) {
            return clazz.cast(io.realm.SessionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(org.snowcorp.app.model.Register.class)) {
            return clazz.cast(io.realm.RegisterRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
            return clazz.cast(io.realm.BookingMovieResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
            return clazz.cast(io.realm.BelongsToCollectionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
            return clazz.cast(io.realm.GenreRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
            return clazz.cast(io.realm.MovieDetailsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(org.snowcorp.app.model.Review.class)) {
            return clazz.cast(io.realm.ReviewRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
            return clazz.cast(io.realm.MovieRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
            return clazz.cast(io.realm.ReviewResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
            return clazz.cast(io.realm.MovieResultRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
            return clazz.cast(io.realm.ProductionCompanyRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(org.snowcorp.app.model.Session.class)) {
            return clazz.cast(io.realm.SessionRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(org.snowcorp.app.model.Register.class)) {
            return clazz.cast(io.realm.RegisterRealmProxy.createDetachedCopy((org.snowcorp.app.model.Register) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.BookingMovieResult.class)) {
            return clazz.cast(io.realm.BookingMovieResultRealmProxy.createDetachedCopy((org.snowcorp.app.model.BookingMovieResult) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.BelongsToCollection.class)) {
            return clazz.cast(io.realm.BelongsToCollectionRealmProxy.createDetachedCopy((org.snowcorp.app.model.BelongsToCollection) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.Genre.class)) {
            return clazz.cast(io.realm.GenreRealmProxy.createDetachedCopy((org.snowcorp.app.model.Genre) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.MovieDetails.class)) {
            return clazz.cast(io.realm.MovieDetailsRealmProxy.createDetachedCopy((org.snowcorp.app.model.MovieDetails) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.Review.class)) {
            return clazz.cast(io.realm.ReviewRealmProxy.createDetachedCopy((org.snowcorp.app.model.Review) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.Movie.class)) {
            return clazz.cast(io.realm.MovieRealmProxy.createDetachedCopy((org.snowcorp.app.model.Movie) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.ReviewResult.class)) {
            return clazz.cast(io.realm.ReviewResultRealmProxy.createDetachedCopy((org.snowcorp.app.model.ReviewResult) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.MovieResult.class)) {
            return clazz.cast(io.realm.MovieResultRealmProxy.createDetachedCopy((org.snowcorp.app.model.MovieResult) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.ProductionCompany.class)) {
            return clazz.cast(io.realm.ProductionCompanyRealmProxy.createDetachedCopy((org.snowcorp.app.model.ProductionCompany) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(org.snowcorp.app.model.Session.class)) {
            return clazz.cast(io.realm.SessionRealmProxy.createDetachedCopy((org.snowcorp.app.model.Session) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
