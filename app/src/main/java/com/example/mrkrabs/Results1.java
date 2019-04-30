package com.example.mrkrabs;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonArray;
import org.json.JSONObject;
import org.json.JSONArray;

import java.lang.String;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;


public class Results1 extends Activity implements OnClickListener{

    private Button JSONTestButton;
    private TextView TestText1;
    private TextView TestText2;
    private TextView TestText3;
    private TextView TestText4;
    private TextView TestText5;
    private int[] ItemIds =  {105,26,28,27,29,33,30,24,18,9,12,19,11,8,62,60,66,64,1,4,5,40,42,44};
    private String[] AvgPrices = {"3057.24","1264.79","2061.65","995.2","1606.72","151.74","62.4","2.72","2.25","2.35","4.78","3.84","2.27","3.11","34.62","43.06","94.36","73.84","14","4","5.75","35.91","15.07","12"};
    private String[] HomePrices = {"","","","","","","","","","","","","","","","","","","","","","","",""};
    private String[] AwayPrices = {"","","","","","","","","","","","","","","","","","","","","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.results1);

        TestText1 = findViewById(R.id.JSONResults1);
        TestText2 = findViewById(R.id.JSONResults2);
        TestText3 = findViewById(R.id.JSONResults3);
        TestText4 = findViewById(R.id.JSONResults4);
        TestText5 = findViewById(R.id.JSONResults5);
        JSONTestButton = findViewById(R.id.Results1Button);
        JSONTestButton.setOnClickListener(this);
        String City1=((GlobalClass) this.getApplication()).getCurrentCity();
        String City2=((GlobalClass) this.getApplication()).getDestinationCity();
        JSONreturnFunction(City1, true);
        JSONreturnFunction(City2, false);
        ((GlobalClass) this.getApplication()).setCurrentPrice(HomePrices);
        ((GlobalClass) this.getApplication()).setDestinationPrice(AwayPrices);



    }

    public void onClick(View a){
        String HomePriceArray[] = ((GlobalClass) this.getApplication()).getCurrentPrice();
        String AwayPriceArray[] = ((GlobalClass) this.getApplication()).getDestinationPrice();
        TestText1.setText(HomePriceArray[0]);
        TestText2.setText(AwayPriceArray[0]);
        TestText3.setText(AwayPriceArray[5]);
        TestText4.setText(AwayPriceArray[16]);
        TestText5.setText(AwayPriceArray[23]);
    }

    private static final String[] Cities = new String[] {"Aberdeen, SD","Aberdeen, WA","Abilene, TX","Abingdon, MD","Acton, MA","Ada, OK","Adelanto, CA","Adrian, MI","Akron, OH","Alameda, CA","Alamogordo, NM","Albany, NY","Albany, OR","Albert Lea, MN","Albuquerque, NM","Alexandria, LA","Alexandria, VA","Allen, TX","Allendale, NJ","Allentown, PA","Alpharetta, GA","Alton, IL","Amarillo, TX","Ames, IA","Amherst, MA","Anaheim, CA","Anchorage, AK","Anderson, SC","Andover, MA","Ankeny, IA","Ann Arbor, MI","Annapolis, MD","Antioch, CA","Apopka, FL","Apple Valley, CA","Appleton, WI","Arlington, TX","Arlington, VA","Ashburn, VA","Asheville, NC","Ashland, OH","Aspen, CO","Astoria, NY","Astoria, OR","Athens, GA","Athens, OH","Atlanta, GA","Atlantic City, NJ","Auburn, AL","Augusta, GA","Augusta, ME","Aurora, CO","Austin, TX","Avondale, AZ","Bakersfield, CA","Baltimore, MD","Bangor, ME","Barrow, AK","Baton Rouge, LA","Battle Creek, MI","Bayonne, NJ","Baytown, TX","Beaumont, TX","Beaverton, OR","Beckley, WV","Belleville, IL","Bellevue, WA","Bellingham, WA","Belmont, CA","Beloit, WI","Bemidji, MN","Bend, OR","Bentonville, AR","Bergen County, NJ","Berkeley, CA","Bethesda, MD","Bethlehem, PA","Beverly Hills, CA","Big Bear Lake, CA","Billings, MT","Biloxi, MS","Binghamton, NY","Birmingham, AL","Bismarck, ND","Blacksburg, VA","Bloomfield Hills, MI","Bloomington, IL","Bloomington, IN","Boca Raton, FL","Boise, ID","Bolingbrook, IL","Boston, MA","Boulder, CO","Bowling Green, KY","Bowling Green, OH","Boynton Beach, FL","Bozeman, MT","Bradenton, FL","Branson, MO","Brea, CA","Breckenridge, CO","Bremerton, WA","Brentwood, CA","Brentwood, TN","Bridgeport, CT","Bridgewater, NJ","Bristol, VA","Bronx, NY","Brookhaven, NY","Brookings","Brooklyn, NY","Brownsville, TX","Brunswick, GA","Brunswick, ME","Buffalo, NY","Buford, GA","Burbank, CA","Burlington, IA","Burlington, VT","Butte, MT","Camarillo, CA","Cambridge, MA","Canton, OH","Cape Girardeau, MO","Carbondale, IL","Carlsbad, CA","Carlsbad, NM","Carson City, NV","Cartersville, GA","Cary, NC","Casper, WY","Cedar City, UT","Cedar Rapids, IA","Cedartown, GA","Champaign, IL","Chandler, AZ","Chapel Hill, NC","Charleston, SC","Charleston, WV","Charlotte, NC","Charlottesville, VA","Chattanooga, TN","Cherry Hill, NJ","Chesapeake, VA","Chevy Chase, MD","Cheyenne, WY","Chicago, IL","Chico, CA","Chula Vista, CA","Cincinnati, OH","Citrus Heights, CA","Clarksville, TN","Clearwater, FL","Cleveland, OH","Clifton, NJ","Clinton Township, MI","Coeur d'Alene, ID","College Park, MD","College Station, TX","Colorado Springs, CO","Columbia, MD","Columbia, MO","Columbia, SC","Columbus, GA","Columbus, IN","Columbus, OH","Concord, CA","Concord, NC","Concord, NH","Conroe, TX","Conway, AR","Cookeville, TN","Coos Bay, OR","Coral Springs, FL","Corona, CA","Corpus Christi, TX","Corvallis, OR","Costa Mesa, CA","Crescent City, CA","Crestview, FL","Crystal Lake, IL","Cumberland, MD","Cumming, GA","Cupertino, CA","Dallas, TX","Danbury, CT","Danville, CA","Danville, VA","Davenport, IA","Davis, CA","Dayton, OH","Daytona Beach, FL","DeKalb, IL","DeLand, FL","Decatur, IL","Deerfield Beach, FL","Del Rio, TX","Delray Beach, FL","Deltona, FL","Denton, TX","Denver, CO","Des Moines, IA","Des Plaines, IL","Detroit, MI","Dothan, AL","Dover, DE","Dover, NH","Downey, CA","Doylestown, PA","Dublin, OH","Duluth, GA","Duluth, MN","Durango, CO","Durham, NC","Eagle River, AK","East Lansing, MI","East Providence, RI","Eau Claire, WI","Eden Prairie, MN","Edison, NJ","Edmond, OK","El Cajon, CA","El Centro, CA","El Paso, TX","Elizabethtown, KY","Elkhart, IN","Elko, NV","Erie, PA","Eugene, OR","Eureka, CA","Evansville, IN","Everett, WA","Fairbanks, AK","Fairfax, VA","Fairfield, CA","Fairfield, CT","Fall River, MA","Fargo, ND","Farmington Hills, MI","Farmington, MO","Farmington, NM","Fayetteville, AR","Fayetteville, NC","Flagstaff, AZ","Flint, MI","Florence, AL","Fond du Lac, WI","Fontana, CA","Fort Collins, CO","Fort Dodge, IA","Fort Lauderdale, FL","Fort Myers, FL","Fort Smith, AR","Fort Walton Beach, FL","Fort Wayne, IN","Fort Worth, TX","Foster City, CA","Franklin, TN","Frederick, MD","Fredericksburg, VA","Fremont, CA","Fresno, CA","Frisco, TX","Gadsden, AL","Gainesville, FL","Gainesville, GA","Gaithersburg, MD","Galesburg, IL","Galveston, TX","Garden Grove, CA","Garland, TX","Gastonia, NC","Geneva, IL","Germantown, MD","Gig Harbor, WA","Gilbert, AZ","Glendale, CA","Goose Creek, SC","Grand Forks, ND","Grand Island, NE","Grand Junction, CO","Grand Rapids, MI","Grants Pass, OR","Grapevine, TX","Grass Valley, CA","Great Falls, MT","Greeley, CO","Green Bay, WI","Greensboro, NC","Greensburg, PA","Greenville, NC","Greenville, SC","Greenville, TX","Gresham, OR","Gulfport, MS","Hagerstown, MD","Hamilton, OH","Hanover, NH","Harlingen, TX","Harrisburg, PA","Harrisonburg va","Hartford, CT","Hattiesburg, MS","Haverhill, MA","Hays, KS","Hayward, CA","Helena, MT","Hempstead, NY","Henderson, NV","Herndon, VA","Hickory, NC","High Point, NC","Highlands Ranch, CO","Hillsboro, OR","Hilo, HI","Hilton Head Island, SC","Hobbs, NM","Hoboken, NJ","Hollywood, FL","Honolulu, HI","Hot Springs, AR","Houma, LA","Houston, TX","Huntington Beach, CA","Huntington, WV","Huntsville, AL","Hyannis, MA","Idaho Falls, ID","Independence, MO","Indianapolis, IN","Iowa City, IA","Irvine, CA","Irving, TX","Islip, NY","Ithaca, NY","Jackson, MS","Jackson, TN","Jackson, WY","Jacksonville, FL","Jacksonville, NC","Jamestown, ND","Jersey City, NJ","Johnson City, TN","Johnstown, PA","Jonesboro, AR","Joplin, MO","Juneau, AK","Jupiter, FL","Kahului, HI","Kailua, HI","Kalamazoo, MI","Kalispell, MT","Kansas City, KS","Kansas City, MO","Katy, TX","Kearney, NE","Kennewick, WA","Kenosha, WI","Kent, WA","Kerrville, TX","Ketchikan, AK","Key West, FL","Killeen, TX","Kingsport, TN","Kingston, NY","Kirksville, MO","Kissimmee, FL","Klamath Falls, OR","Knoxville, TN","Kokomo, IN","La Crosse, WI","Lafayette, IN","Lafayette, LA","Lake Charles, LA","Lake Forest, CA","Lake Havasu City, AZ","Lake Worth, FL","Lakeland, FL","Lancaster, CA","Lancaster, PA","Lansing, MI","Laramie, WY","Laredo, TX","Las Cruces, NM","Las Vegas, NV","Laurel, MD","Lawrence, KS","Lawrence, MA","Lawrenceville, GA","Lawton, OK","Levittown, PA","Lewiston, ME","Lexington Park, MD","Lexington, KY","Lima, OH","Lincoln, NE","Lisle, IL","Little Rock, AR","Livermore, CA","Livonia, MI","Logan, UT","London, KY","Long Beach, CA","Long Branch, NJ","Long Island, NY","Longmont, CO","Longview, TX","Longview, WA","Los Angeles, CA","Los Gatos, CA","Louisville, KY","Loveland, CO","Lubbock, TX","Lynchburg, VA","Macon, GA","Madison, WI","Manassas, VA","Manchester, NH","Mandeville, LA","Manhattan, KS","Mankato, MN","Mansfield, OH","Marietta, GA","Marlborough, MA","Marquette, MI","Martinez, CA","Martinsburg, WV","Massapequa, NY","Maui, HI","McAllen, TX","McHenry, IL","McKinney, TX","Mechanicsburg, PA","Medford, OR","Melbourne, FL","Memphis, TN","Merced, CA","Mesa, AZ","Mesquite, TX","Miami, FL","Midland, MI","Midland, TX","Milwaukee, WI","Minneapolis, MN","Minot, ND","Mission Viejo, CA","Missoula, MT","Moberly, MO","Mobile, AL","Modesto, CA","Moline, IL","Monroe, LA","Montclair, NJ","Monterey, CA","Montgomery, AL","Mooresville, NC","Morgantown, WV","Morristown, NJ","Morristown, TN","Morrisville, PA","Moscow, ID","Mount Pleasant, MI","Mount Vernon","Mountain View, CA","Muncie, IN","Murfreesboro, TN","Murrieta, CA","Muskegon, MI","Myrtle Beach, SC","Napa, CA","Naperville, IL","Naples, FL","Nashua, NH","Nashville, TN","Natick, MA","New Bedford, MA","New Bern, NC","New Braunfels, TX","New City, NY","New Haven, CT","New Orleans, LA","New Port Richey, FL","New Windsor, NY","New York, NY","Newark, DE","Newark, NJ","Newport Beach, CA","Newport News, VA","Newport, OR","Newport, RI","Newton, MA","Norfolk, VA","Normal, IL","Norman, OK","North Brunswick, NJ","North Platte, NE","Northampton, MA","Norwalk, CT","Norwich, CT","O'Fallon, MO","Oakland, CA","Ocala, FL","Oceanside, CA","Odessa, TX","Ogden, UT","Oklahoma City, OK","Olympia, WA","Omaha, NE","Ontario,CA","Orem, UT","Orlando, FL","Oroville, CA","Oshkosh, WI","Overland Park, KS","Owensboro, KY","Oxnard, CA","Paducah, KY","Palm Coast, FL","Palm Springs, CA","Palmdale, CA","Palo Alto, CA","Panama City, FL","Park City, UT","Parkersburg, WV","Parsippany-Troy Hills, NJ","Pasadena, CA","Paso Robles, CA","Passaic, NJ","Paterson, NJ","Pembroke Pines, FL","Pensacola, FL","Peoria, AZ","Peoria, IL","Philadelphia, PA","Phoenix, AZ","Pinehurst, NC","Pittsburgh, PA","Pittsfield, MA","Plano, TX","Plattsburgh, NY","Pleasant Hill, CA","Pleasanton, CA","Plymouth, MI","Pocatello, ID","Pomona, CA","Port Huron, MI","Port St Lucie, FL","Portland, ME","Portland, OR","Portsmouth, NH","Poughkeepsie, NY","Prescott, AZ","Princeton, NJ","Providence, RI","Pueblo, CO","Pullman, WA","Puyallup, WA","Queen Creek, AZ","Queens, NY","Raleigh, NC","Rancho Cucamonga, CA","Rapid City, SD","Reading, PA","Red Bank, NJ","Redding, CA","Redlands, CA","Redmond, WA","Redondo Beach, CA","Redwood City, CA","Rehoboth Beach, DE","Reno, NV","Renton, WA","Reston, VA","Rice Lake, WI","Richland, WA","Richmond, KY","Richmond, VA","Ridgewood, NJ","Rio Rancho, NM","Riverside, CA","Roanoke, VA","Rochester, MI","Rochester, MN","Rochester, NY","Rock Hill, SC","Rock Springs, WY","Rockford, IL","Rocklin, CA","Rockville, MD","Rogers, AR","Roseburg, OR","Roseville, CA","Russellville, AR","Sacramento, CA","Saginaw, MI","Saint Charles, MO","Saint Cloud, MN","Saint George, UT","Saint Joseph, MO","Saint Louis, MO","Saint Paul, MN","Saint Petersburg, FL","Salem, OR","Salina, KS","Salisbury, MD","Salt Lake City, UT","San Angelo, TX","San Antonio, TX","San Bernardino, CA","San Diego, CA","San Francisco, CA","San Jose, CA","San Leandro, CA","San Luis Obispo, CA","San Marcos, TX","San Mateo, CA","San Rafael, CA","Sandusky, OH","Santa Ana, CA","Santa Barbara, CA","Santa Clara, CA","Santa Clarita, CA","Santa Cruz, CA","Santa Fe, NM","Santa Maria, CA","Santa Monica, CA","Santa Rosa, CA","Sarasota, FL","Savannah, GA","Schaumburg, IL","Schenectady, NY","Scottsdale, AZ","Scranton, PA","SeaTac, WA","Seaside, OR","Seattle, WA","Sebring, FL","Sequim, WA","Seward, AK","Sheboygan, WI","Sheridan, WY","Sherman, TX","Shreveport, LA","Sierra Vista, AZ","Silver Spring, MD","Simi Valley, CA","Sioux City, IA","Sioux Falls, SD","Smithtown, NY","Somerset, NJ","Somerville, MA","South Bend, IN","Southfield, MI","Spartanburg, SC","Spokane, WA","Spring Hill, FL","Springfield, IL","Springfield, MA","Springfield, MO","Springfield, OR","Springfield, VA","St. Augustine, FL","Stamford, CT","Starkville, MS","State College, PA","Staten Island, NY","Statesboro, GA","Sterling Heights, MI","Stevens Point, WI","Stillwater, OK","Stockton, CA","Stroudsburg, PA","Sugar Land, TX","Sumter, SC","Sunnyvale, CA","Sunrise, FL","Surprise, AZ","Syracuse, NY","Tacoma, WA","Tallahassee, FL","Tampa, FL","Taunton, MA","Teaneck, NJ","Temecula, CA","Tempe, AZ","Temple, TX","Terre Haute, IN","Texarkana, AR","Texarkana, TX","The Woodlands, TX","Thornton, CO","Thousand Oaks, CA","Toledo, OH","Toms River, NJ","Topeka, KS","Torrance, CA","Torrington, CT","Traverse City, MI","Trenton, NJ","Troy, MI","Tucson, AZ","Tulsa, OK","Tuscaloosa, AL","Tustin, CA","Twin Falls, ID","Tyler, TX","Ukiah, CA","Upland, CA","Urbana, IL","Utica, NY","Valdosta, GA","Vallejo, CA","Valparaiso, IN","Vancouver, WA","Venice, FL","Ventura, CA","Vero Beach, FL","Victoria, TX","Victorville, CA","Virginia Beach, VA","Visalia, CA","Vista, CA","Waco, TX","Wadsworth, OH","Waipahu, HI","Waldorf, MD","Walla Walla, WA","Walnut Creek, CA","Warner Robins, GA","Warren, MI","Washington, DC","Wasilla, AK","Waterbury, CT","Waterloo, IA","Watertown, NY","Watertown, SD","Waukesha, WI","Wausau, WI","Waynesville, MO","Wenatchee, WA","West Chester, PA","West Hartford, CT","West Hollywood, CA","West New York, NJ","West Palm Beach, FL","Westport, CT","Wheaton, IL","Wheeling, WV","White Plains, NY","Wichita Falls, TX","Wichita, KS","Wilkes-Barre, PA","Williamsburg, VA","Williamsport, PA","Willimantic, CT","Williston, ND","Wilmington, DE","Wilmington, NC","Winchester, VA","Winston-Salem, NC","Woodbridge, NJ","Woodbridge, VA","Wooster, OH","Worcester, MA","Wylie, TX","Yakima, WA","Yonkers, NY","York, PA","Youngstown, OH","Ypsilanti, MI","Yreka, CA","Yuba City, CA","Yucca Valley, CA","Yuma, AZ","Zanesville, OH"};
    private void JSONreturnFunction(String City, final boolean X){
        String URL = "http://www.numbeo.com:8008/api/city_prices?api_key=3suzspurfdpdf4&query="+City;
        RequestQueue request = Volley.newRequestQueue(this);
        Gson json=new Gson();

        JsonObjectRequest objectRequest= new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, Integer.toString(response.optJSONArray("prices").length()));
                        int AL = response.optJSONArray("prices").length();
                        for(int j = 0; j<24; j++) {
                            for (int i = 0; i <AL-1;  i++) {
                                if (response.optJSONArray("prices").optJSONObject(i).optInt("item_id") == ItemIds[j]) {
                                    if (X == true) {
                                        HomePrices[j] = response.optJSONArray("prices").optJSONObject(i).optString("average_price");
                                    } else {
                                        AwayPrices[j] = response.optJSONArray("prices").optJSONObject(i).optString("average_price");
                                    }
                                }
                            }
                            if(X==true) {
                                if (HomePrices[j] == "") {
                                    HomePrices[j] = AvgPrices[j];
                                }
                            }else {
                                if (AwayPrices[j] == "") {
                                    AwayPrices[j] = AvgPrices[j];
                                }
                            }
                        }

//                        String X0 =response.optJSONArray("prices").optJSONObject(40).optString("average_price");
//                        String X1 =response.optJSONArray("prices").optJSONObject(21).optString("average_price");
//                        String X2 =response.optJSONArray("prices").optJSONObject(23).optString("average_price");
//                        String X3 =response.optJSONArray("prices").optJSONObject(22).optString("average_price");
//                        String X4 =response.optJSONArray("prices").optJSONObject(24).optString("average_price");
//                        String X5 =response.optJSONArray("prices").optJSONObject(27).optString("average_price");
//                        String X6 =response.optJSONArray("prices").optJSONObject(25).optString("average_price");
//                        String X7 =response.optJSONArray("prices").optJSONObject(19).optString("average_price");
//                        String X8 =response.optJSONArray("prices").optJSONObject(16).optString("average_price");
//                        String X9 =response.optJSONArray("prices").optJSONObject(8).optString("average_price");
//                        String X10 =response.optJSONArray("prices").optJSONObject(10).optString("average_price");
//                        String X11 =response.optJSONArray("prices").optJSONObject(17).optString("average_price");
//                        String X12 =response.optJSONArray("prices").optJSONObject(9).optString("average_price");
//                        String X13 =response.optJSONArray("prices").optJSONObject(7).optString("average_price");
//                        String X14 =response.optJSONArray("prices").optJSONObject(32).optString("average_price");
//                        String X15 =response.optJSONArray("prices").optJSONObject(31).optString("average_price");
//                        String X16 =response.optJSONArray("prices").optJSONObject(34).optString("average_price");
//                        String X17 =response.optJSONArray("prices").optJSONObject(33).optString("average_price");
//                        String X18 =response.optJSONArray("prices").optJSONObject(0).optString("average_price");
//                        String X19 =response.optJSONArray("prices").optJSONObject(3).optString("average_price");
//                        String X20 =response.optJSONArray("prices").optJSONObject(4).optString("average_price");
//                        String X21 =response.optJSONArray("prices").optJSONObject(28).optString("average_price");
//                        String X22 =response.optJSONArray("prices").optJSONObject(29).optString("average_price");
//                        String X23 =response.optJSONArray("prices").optJSONObject(30).optString("average_price");

//
//                        if (X==true){
//                            HomePrices[0]=X0;
//                            HomePrices[1]=X1;
//                            HomePrices[2]=X2;
//                            HomePrices[3]=X3;
//                            HomePrices[4]=X4;
//                            HomePrices[5]=X5;
//                            HomePrices[6]=X6;
//                            HomePrices[7]=X7;
//                            HomePrices[8]=X8;
//                            HomePrices[9]=X9;
//                            HomePrices[10]=X10;
//                            HomePrices[11]=X11;
//                            HomePrices[12]=X12;
//                            HomePrices[13]=X13;
//                            HomePrices[14]=X14;
//                            HomePrices[15]=X15;
//                            HomePrices[16]=X16;
//                            HomePrices[17]=X17;
//                            HomePrices[18]=X18;
//                            HomePrices[19]=X19;
//                            HomePrices[20]=X20;
//                            HomePrices[21]=X21;
//                            HomePrices[22]=X22;
//                            HomePrices[23]=X23;
                        }
//                        else {
//                            AwayPrices[0]=X0;
//                            AwayPrices[1]=X1;
//                            AwayPrices[2]=X2;
//                            AwayPrices[3]=X3;
//                            AwayPrices[4]=X4;
//                            AwayPrices[5]=X5;
//                            AwayPrices[6]=X6;
//                            AwayPrices[7]=X7;
//                            AwayPrices[8]=X8;
//                            AwayPrices[9]=X9;
//                            AwayPrices[10]=X10;
//                            AwayPrices[11]=X11;
//                            AwayPrices[12]=X12;
//                            AwayPrices[13]=X13;
//                            AwayPrices[14]=X14;
//                            AwayPrices[15]=X15;
//                            AwayPrices[16]=X16;
//                            AwayPrices[17]=X17;
//                            AwayPrices[18]=X18;
//                            AwayPrices[19]=X19;
//                            AwayPrices[20]=X20;
//                            AwayPrices[21]=X21;
//                            AwayPrices[22]=X22;
//                            AwayPrices[23]=X23;
//                        }
//
//                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("error", error.toString());
                    }
                }
        );
        request.add(objectRequest);

    }
}