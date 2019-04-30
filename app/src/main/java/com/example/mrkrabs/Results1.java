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
    private TextView TestText6;
    private TextView TestText7;
    private TextView TestText8;
    private TextView TestText9;
    private TextView TestText10;
    private int[] ItemIds =  {105,26,28,27,29,33,30,24,18,9,12,19,11,8,62,60,66,64,1,4,5,40,42,44};
    private String[] AvgPrices = {"3057.24","1264.79","2061.65","995.2","1606.72","151.74","62.4","2.72","2.25","2.35","4.78","3.84","2.27","3.11","34.62","43.06","94.36","73.84","14","4","5.75","35.91","15.07","12"};
    private String[] HomePrices = {"","","","","","","","","","","","","","","","","","","","","","","",""};
    private String[] AwayPrices = {"","","","","","","","","","","","","","","","","","","","","","","",""};
    private float Data[] = new float[13];
    private float[] Outputs = {0,0,0,0,0,0,0,0,0,0};
    private int[] IntOutputs = {0,0,0,0,0,0,0,0,0,0};
    private String[] StringOutputs = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.results1);

        TestText1 = findViewById(R.id.JSONResults1);
        TestText2 = findViewById(R.id.JSONResults2);
        TestText3 = findViewById(R.id.JSONResults3);
        TestText4 = findViewById(R.id.JSONResults4);
        TestText5 = findViewById(R.id.JSONResults5);
        TestText6 = findViewById(R.id.JSONResults6);
        TestText7 = findViewById(R.id.JSONResults7);
        TestText8 = findViewById(R.id.JSONResults8);
        TestText9 = findViewById(R.id.JSONResults9);
        TestText10 = findViewById(R.id.JSONResults10);
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
        CreateData();
        Calculations(Data);
        String HomePriceArray[] = ((GlobalClass) this.getApplication()).getCurrentPrice();
        String AwayPriceArray[] = ((GlobalClass) this.getApplication()).getDestinationPrice();
        TestText1.setText(StringOutputs[0]);
        TestText2.setText(StringOutputs[1]);
        TestText3.setText(StringOutputs[2]);
        TestText4.setText(StringOutputs[3]);
        TestText5.setText(StringOutputs[4]);
        TestText6.setText(StringOutputs[5]);
        TestText7.setText(StringOutputs[6]);
        TestText8.setText(StringOutputs[7]);
        TestText9.setText(StringOutputs[8]);
        TestText10.setText(StringOutputs[9]);
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

                        }
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

    private void CreateData(){
        int[] IntData = new int[13];
        Log.d(TAG, ((GlobalClass) this.getApplication()).getExpectedSalary());
        IntData[0]=Integer.valueOf(((GlobalClass) this.getApplication()).getExpectedSalary());
        IntData[1]=Integer.valueOf(((GlobalClass) this.getApplication()).getRentPerMonth());
        if(((GlobalClass) this.getApplication()).getLocation()=="In City"){
            IntData[2]=0;
        } else{
            IntData[2]=1;
        }
        IntData[3]=Integer.valueOf(((GlobalClass) this.getApplication()).getBedrooms());
        IntData[4]=Integer.valueOf(((GlobalClass) this.getApplication()).getUtilities());
        IntData[5]=Integer.valueOf(((GlobalClass) this.getApplication()).getTransportationCost());
        if(((GlobalClass) this.getApplication()).getTransportation()=="Private"){
            IntData[6]=0;
        } else{
            IntData[6]=1;
        }
        IntData[7]=Integer.valueOf(((GlobalClass) this.getApplication()).getGrocery());
        IntData[8]=Integer.valueOf(((GlobalClass) this.getApplication()).getClothes());
        IntData[9]=Integer.valueOf(((GlobalClass) this.getApplication()).getDining());
        IntData[10]=Integer.valueOf(((GlobalClass) this.getApplication()).getAlcohol());
        IntData[11]=Integer.valueOf(((GlobalClass) this.getApplication()).getFitness());
        IntData[12]=Integer.valueOf(((GlobalClass) this.getApplication()).getMisc());
        for(int i=0;i<13;i++){
            Data[i]=(float)IntData[i];
            Log.d(TAG, String.valueOf(Data[i]));
        }
    }
    private void Calculations(float[] Inputs){
        float[] AwayFloat = new float[24];
        float[] HomeFloat = new float[24];
        for(int i =0; i<24;i++){
//            Log.d(TAG, AwayPrices[i]);
            AwayFloat[i]=Float.valueOf(AwayPrices[i]);
            HomeFloat[i]=Float.valueOf(HomePrices[i]);
        }
        Outputs[0]=Inputs[0]-AwayFloat[0]*12;
        if(Inputs[2]==0){
            float AwayCityRent = ((AwayFloat[2]-AwayFloat[1])/2)*Inputs[3]+(AwayFloat[1])-((AwayFloat[2]-AwayFloat[1])/2);
            float HomeCityRent = ((HomeFloat[2]-HomeFloat[1])/2)*Inputs[3]+(HomeFloat[1])-((HomeFloat[2]-HomeFloat[1])/2);
            Outputs[1]=Inputs[1]*AwayCityRent/HomeCityRent/Inputs[3];
        }
        if(Inputs[2]==1){
            float AwayCityRent = ((AwayFloat[4]-AwayFloat[3])/4)*Inputs[3]+(AwayFloat[3])-((AwayFloat[4]-AwayFloat[3])/4);
            float HomeCityRent = ((HomeFloat[4]-HomeFloat[3])/4)*Inputs[3]+(HomeFloat[3])-((HomeFloat[4]-HomeFloat[3])/4);
            Outputs[1]=Inputs[1]*AwayCityRent/HomeCityRent/Inputs[3];
        }
        Outputs[2]=Inputs[4]*(AwayFloat[5]+AwayFloat[6])/(HomeFloat[5]+HomeFloat[6]);
        if(Inputs[6]==0){
            Outputs[3]=Inputs[5]*AwayFloat[7]/HomeFloat[7];
        }else{
            Outputs[3]=Inputs[5]*AwayFloat[8]/HomeFloat[8];
        }
        Outputs[4]=Inputs[7]*(AwayFloat[9]+AwayFloat[10]+AwayFloat[11]+AwayFloat[12]+AwayFloat[13])/(HomeFloat[9]+HomeFloat[10]+HomeFloat[11]+HomeFloat[12]+HomeFloat[13]);
        Outputs[5]=Inputs[8]*(AwayFloat[14]+AwayFloat[15]+AwayFloat[16]+AwayFloat[17])/(HomeFloat[14]+HomeFloat[15]+HomeFloat[16]+HomeFloat[17]);
        Outputs[6]=Inputs[9]*AwayFloat[18]/HomeFloat[18];
        Outputs[7]=Inputs[10]*(AwayFloat[19]+AwayFloat[20])/(HomeFloat[19]+HomeFloat[20]);
        Outputs[8]=Inputs[11]*(AwayFloat[21]+AwayFloat[22])/(HomeFloat[21]+HomeFloat[22]);
        Outputs[9]=Inputs[12]*(AwayFloat[22]+AwayFloat[23])/(HomeFloat[22]+HomeFloat[23]);
        for(int i =0; i<10;i++){
            IntOutputs[i]=(int)Outputs[i];
            StringOutputs[i]=String.valueOf(IntOutputs[i]);
        }
    }
}
