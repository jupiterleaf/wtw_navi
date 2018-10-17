package tk.walkingthisway.www.wtw_navi;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

// use this class as a tool to fetach data from API
// the data is stored as JSON
public class fetchData extends AsyncTask {
    private static final String TAG = fetchData.class.getSimpleName();
    String data = "";
    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            //URL url = new URL("https://localhost:44365/api/getroute");
            URL url = new URL("https://www.walkingthisway.tk/api/getroute/");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream = httpsURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }
            Log.e(TAG,"FD");
            Log.e(TAG,"data"+data);
            //JSONObject lll=null;
            try {
                MainActivity.jsonObject = new JSONObject(data);
                //lll = new JSONObject(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //JSONArray jsonArray = MainActivity.jsonObject.getJSONArray("methodParam");
            //Log.e(TAG,"data"+jsonArray.getJSONObject(0).getDouble("latitude"));
            return data;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
