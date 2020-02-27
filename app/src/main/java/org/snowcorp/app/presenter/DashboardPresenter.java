package org.snowcorp.app.presenter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.TextView;

import org.snowcorp.app.R;
import org.snowcorp.app.activity.LoginActivity;
import org.snowcorp.app.fragment.MovieFragment;
import org.snowcorp.app.utils.CustomDialog;
import org.snowcorp.app.utils.GlobalUtils;
import org.snowcorp.app.view.DashboardView;
import org.snowcorp.app.view.DialogListner;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Wongel on 7/14/17.
 */

public class DashboardPresenter {
    private Context context;
    private DashboardView view;


    public DashboardPresenter(Context context, DashboardView view) {
        this.context = context;
        this.view = view;

    }


    public void onNavigationItemClicked(int id) {
        switch (id) {
            case R.id.movieList:
                GlobalUtils.addFragment(context, new MovieFragment(), R.id.container, false);
                break;
            case R.id.calendar:
                view.showToast("Working on Calender");
//                GlobalUtils.addFragment(context, new CalendarFragment(), R.id.container, false);
                break;
            case R.id.booking:
                view.showToast("Working on Booking");
//                GlobalUtils.addFragment(context, new MovieBookingFragment(), R.id.container, false);
                break;
//            case R.id.favourite:
//                GlobalUtils.addFragment(context, new FavouriteFragment(), R.id.container, false);
//                break;
            case R.id.about:
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("About Us");
                TextView text = new TextView(context);
                text.setText("Disclaimer:-\n" +
                        "All the logos, trademarks and other symbols are the properties of their respective owners. We do not endorse or support any channel or any company. This app is distributed \"as is\" without warranty of any kind and the user may use it on his/her own risk. This app's users and third parties, agree to indemnify and hold harmless this app's creators and it's agents, from any damages claimed as a result of information, resources, products or services, or third party links obtained from this app.If anybody still finds this app harmful in any way, they must send a request/notice to the creators first to remove the discrepancy.");
                text.setPadding(16, 8, 16, 8);
                builder.setView(text);
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
                break;

            case R.id.logout:
                CustomDialog.showLogOutDialog(context, new DialogListner() {

                    @Override
                    public void onOkClicked() {
                        RealmConfiguration config = Realm.getDefaultInstance().getConfiguration();
                        Realm realm = Realm.getDefaultInstance();
                        while (!realm.isClosed())
                            realm.close();
                        Realm.deleteRealm(config);
                        Realm.removeDefaultConfiguration();

                        GlobalUtils.navigateActivity(context, true, LoginActivity.class);
                    }
                });
                break;
        }
    }


}
