package spm.mvc_mvp_mvvm.mvvm_room_lifecycle_dagger.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import okhttp3.internal.Util;
import spm.mvc_mvp_mvvm.mvvm_room_lifecycle_dagger.countrylist.model.CountryResult;
import spm.mvc_mvp_mvvm.mvvm_room_lifecycle_dagger.dto.Movie;
import spm.mvc_mvp_mvvm.mvvm_room_lifecycle_dagger.listeners.MoviesListener;
import spm.mvc_mvp_mvvm.mvvm_room_lifecycle_dagger.networkcall.MovieRepository;


public class MoviesListViewModel extends AndroidViewModel  implements LifecycleObserver  {

    private static final String TAG = "MoviesListViewModel";

    private  LiveData<List<Movie>> projectListObservable = new MutableLiveData<>();
    private  LiveData<List<CountryResult>> countryList = new MutableLiveData<>();

    public MoviesListViewModel(@NonNull Application application) {
        super(application);
        projectListObservable = MovieRepository.getInstance().getMoviesList();
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<List<Movie>> getMoviesListObservable() {
        return projectListObservable;
    }

    public LiveData<List<CountryResult>> getCOuntriesListObservable() {
        return countryList;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void any() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        Log.i(TAG, "onCreate: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        projectListObservable = MovieRepository.getInstance().getMoviesList();
        Log.i(TAG, "onStart: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        Log.i(TAG, "onStop: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
        Log.i(TAG, "onPause: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        Log.i(TAG, "onResume: ");
    }

}