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


    }

    public void onClick(View a){
        String City1=((GlobalClass) this.getApplication()).getCurrentCity();
        String City2=((GlobalClass) this.getApplication()).getDestinationCity();
        JSONreturnFunction(City1, true);
        JSONreturnFunction(City2, false);
        ((GlobalClass) this.getApplication()).setCurrentPrice(HomePrices);
        ((GlobalClass) this.getApplication()).setDestinationPrice(AwayPrices);
        String HomePriceArray[] = ((GlobalClass) this.getApplication()).getCurrentPrice();
        String AwayPriceArray[] = ((GlobalClass) this.getApplication()).getDestinationPrice();
        TestText1.setText(HomePriceArray[0]);
        TestText2.setText(AwayPriceArray[0]);
        TestText3.setText(AwayPriceArray[5]);
        TestText4.setText(AwayPriceArray[16]);
        TestText5.setText(AwayPriceArray[23]);
    }

    private static final String[] Cities = new String[] {
            "Anchorage, AK","Barrow, AK","Bethel, AK","Eagle River, AK","Fairbanks, AK","Juneau, AK","Ketchikan, AK","Kodiak, AK","Nome, AK","Palmer, AK","Sand Point, AK","Seward, AK","Sitka, AK","Thorne Bay, AK","Wasilla, AK","Anniston, AL","Ashland, AL","Auburn, AL","Bay Minette, AL","Birmingham, AL","Cullman, AL","Decatur, AL","Dothan, AL","Enterprise, Al","Florence, AL","Gadsden, AL","Huntsville, AL","Jacksonville, AL","Luverne, AL","Mobile, AL","Montevallo, AL","Montgomery, AL","Northport, AL","Orange beach, AL","Pisgah, AL","Scottsboro, AL","Talladega, AL","Troy, AL","Tuscaloosa, AL","Tuscumbia, AL","Weaver, AL","Winfield, AL","Ash Flat, AR","Bentonville, AR","Bismarck, AR","Blytheville, AR","Cabot, AR","Cherokee Village, AR","Conway, AR","El Dorado, AR","Fayetteville, AR","Fort Smith, AR","Greenbriar, AR","Harrison, AR","Helena, AR","Hope, AR","Hot Springs, AR","Jonesboro, AR","Little Rock, AR","Magnolia, AR","Marion, AR","Melbourne, AR","Mena, AR","Paris, AR","Rogers, AR","Russellville, AR","Stuttgart, AR","Texarkana, AR","Van Buren, AR","Western Grove, AR","Anthem, AZ","Avondale, AZ","Bisbee, AZ","Buckeye, AZ","Bullhead City, AZ","Cave Creek, AZ","Chandler, AZ","Cottonwood, AZ","Flagstaff, AZ","Gilbert, AZ","Glendale, AZ","Lake Havasu City, AZ","Maricopa, AZ","Mesa, AZ","Morenci, AZ","Payson, AZ","Peoria, AZ","Phoenix, AZ","Prescott, AZ","Queen Creek, AZ","Scottsdale, AZ","Sedona, AZ","Sierra Vista, AZ","Surprise, AZ","Tempe, AZ","Tucson, AZ","Wenden, AZ","Winslow, AZ","Yuma, AZ","Adelanto, CA","Agoura Hills, CA","Alameda, CA","Aliso Viejo, CA","American Canyon, CA","Anaheim, CA","Anderson, CA","Antioch, CA","Apple Valley, CA","Arcadia, CA","Arden-Arcade, CA","Arroyo Grande, CA","Atascadero, CA","Auburn, CA","Bakersfield, CA","Banning, CA","Baywood-Los Osos, CA","Belmont, CA","Berkeley, CA","Beverly Hills, CA","Big Bear Lake, CA","Bishop, CA","Bodega Bay, CA","Bolinas, CA","Boron, CA","Brea, CA","Brentwood, CA","Burbank, CA","Camarillo, CA","Canoga Park, CA","Canyon Lake, CA","Carlsbad, CA","Carmel By The Sea, CA","Carson, CA","Castro Valley, CA","Cerritos, CA","Chico, CA","Chula Vista, CA","Citrus Heights, CA","Coachella, CA","Colton, CA","Colusa, CA","Concord, CA","Corcoran, CA","Corona, CA","Cortina Indian Rancheria, CA","Costa Mesa, CA","Crescent City, CA","Crestline, CA","Cupertino, CA","Danville, CA","Davis, CA","Desert Hot Springs, CA","Diamond Bar, CA","Discovery Bay, CA","Downey, CA","El Cajon, CA","El Centro, CA","Encinitas, CA","Escondido, CA","Eureka, CA","Fairfield, CA","Fontana, CA","Fortuna, CA","Foster City, CA","Fountain Valley, CA","Fremont, CA","Fresno, CA","Fullerton, CA","Garberville, CA","Garden Grove, CA","Gilroy, CA","Glendale, CA","Glendora, CA","Grass Valley, CA","Gridley, CA","Grover Beach, CA","Hayward, CA","Hermosa Beach, CA","Highland, CA","Huntington Beach, CA","Huntington Park, CA","Imperial, CA","Indio, CA","Irvine, CA","Isla Vista, CA","Jackson, CA","Johannesberg, CA","La Mesa, CA","Laguna Niguel, CA","Lake Elsinore, CA","Lake Forest, CA","Lakeport, CA","Lancaster, CA","Lathrop, CA","Leggett, CA","Lemon Grove, CA","Livermore, CA","Lomita, CA","Lompoc, CA","Long Beach, CA","Los Angeles, CA","Los Gatos, CA","Madera, CA","Malibu, CA","Manhattan Beach, CA","Marina, CA","Martinez, CA","Merced, CA","Mission Viejo, CA","Modesto, CA","Monrovia, CA","Montecito, CA","Monterey, CA","Monterey Park, CA","Mount Shasta, CA","Mountain House, CA","Mountain View, CA","Murrieta, CA","Napa, CA","Newport Beach, CA","Norwalk, CA","Oakland, CA","Oceanside, CA","Ojai, CA","Oroville, CA","Oxnard, CA","Pacific Palisades, CA","Palm Springs, CA","Palmdale, CA","Palo Alto, CA","Paradise, CA","Pasadena, CA","Paso Robles, CA","Piedmont, CA","Pleasant Hill, CA","Pleasanton, CA","Pomona, CA","Porter Ranch, CA","Portola, CA","Quincy, CA","Rancho Cucamonga, CA","Rancho Palos Verdes, CA","Redding, CA","Redlands, CA","Redondo Beach, CA","Redwood City, CA","Ridgecrest, CA","Ripon, CA","Riverside, CA","Rocklin, CA","Roseville, CA","Sacramento, CA","San Bernardino, CA","San Diego, CA","San Dimas, CA","San Francisco, CA","San Jose, CA","San Leandro, CA","San Luis Obispo, CA","San Mateo, CA","San Rafael, CA","Santa Ana, CA","Santa Barbara, CA","Santa Clara, CA","Santa Clarita, CA","Santa Cruz, CA","Santa Maria, CA","Santa Monica, CA","Santa Rosa, CA","Saratoga, CA","Seal Beach, CA","Simi Valley, CA","Stanford, CA","Stockton, CA","Sunnyvale, CA","Susanville, CA","Temecula, CA","Thousand Oaks, CA","Tipton, CA","Torrance, CA","Tracy, CA","Truckee, CA","Turlock, CA","Tustin, CA","Ukiah, CA","Upland, CA","Vacaville, CA","Vallejo, CA","Valley Center, CA","Ventura, CA","Victorville, CA","Visalia, CA","Vista, CA","Walnut, CA","Walnut Creek, CA","Watsonville, CA","West Hollywood, CA","Westminster, CA","Yreka, CA","Yuba City, CA","Yucaipa, CA","Yucca Valley, CA","Ontario, CA","Aspen, CO","Aurora, CO","Avon, CO","Battlement Mesa, CO","Boulder, CO","Breckenridge, CO","Broomfield, CO","Canon City, CO","Colorado Springs, CO","Crestone, CO","Denver, CO","Durango, CO","Fairplay, CO","Fort Collins, CO","Glenwood Springs, CO","Grand Junction, CO","Greeley, CO","Gunnison, CO","Highlands Ranch, CO","Lafayette, CO","Laporte, CO","Longmont, CO","Loveland, CO","Monument, CO","Pagosa Springs, CO","Pueblo, CO","Thornton, CO","Westcliffe, CO","Woodland Park, CO","Avon, CT","Bridgeport, CT","Danbury, CT","Essex, CT","Fairfield, CT","Farmington, CT","Granby, CT","Greenwich, CT","Groton, CT","Hartford, CT","Mansfield, CT","Middletown, CT","New Haven, CT","New London, CT","New Milford, CT","Niantic, CT","Norwalk, CT","Norwich, CT","Putnam, CT","Ridgefield, CT","Rocky Hill, CT","Seymour, CT","Stamford, CT","Torrington, CT","Trumbull, CT","Wallingford, CT","Waterbury, CT","West Hartford, CT","Weston, CT","Westport, CT","Wethersfield, CT","Willimantic, CT","Windsor, CT","Washington, DC","Bear, DE","Dover, DE","Georgetown, DE","Middletown, DE","Milton, DE","Newark, DE","Rehoboth Beach, DE","Wilmington, DE","Apopka, FL","Auburndale, FL","Boca Raton, FL","Boynton Beach, FL","Bradenton, FL","Cape Canaveral, FL","Clearwater, FL","Cooper City, FL","Coral Springs, FL","Crestview, FL","Cutler Bay, FL","Daytona Beach, FL","Deerfield Beach, FL","DeLand, FL","Delray Beach, FL","Deltona, FL","Flagler Beach, FL","Fort Lauderdale, FL","Fort Myers, FL","Fort Walton Beach, FL","Gainesville, FL","Gulf Breeze, FL","Hallandale Beach, FL","Hialeah, FL","Hollywood, FL","Homestead, FL","Indialantic, FL","Jacksonville, FL","Jupiter, FL","Key West, FL","Kissimmee, FL","Lake Worth, FL","Lakeland, FL","Largo, FL","Marathon, FL","Melbourne, FL","Miami, FL","Middleburg, FL","Milton, FL","Naples, FL","New Port Richey, FL","New Smyrna Beach, FL","Ocala, FL","Odessa, FL","Orlando, FL","Palatka, FL","Palm Coast, FL","Palmetto, FL","Panama City, FL","Pembroke Pines, FL","Pensacola, FL","Pinellas Park, FL","Port St Joe, FL","Port St Lucie, FL","Safety Harbor, FL","Saint Petersburg, FL","Santa Rosa Beach, FL","Sarasota, FL","Satellite Beach, FL","Sebring, FL","Seminole, FL","Spring Hill, FL","St. Augustine, FL","Stuart, FL","Sun City Center, FL","Sunny Isles Beach, FL","Sunrise, FL","Tallahassee, FL","Tampa, FL","The Villages, FL","Titusville, FL","Venice, FL","Vero Beach, FL","West Palm Beach, FL","Weston, FL","Winter Haven, FL","Zephyrhills, FL","Albany, GA","Alpharetta, GA","Athens, GA","Atlanta, GA","Augusta, GA","Bainbridge, GA","Brookhaven, GA","Brunswick, GA","Buckhead, GA","Buford, GA","Cartersville, GA","Cedartown, GA","Clayton, GA","Columbus, GA","Cumming, GA","Dahlonega, GA","Dalton, GA","Douglas, GA","Douglasville, GA","Duluth, GA","Evans, GA","Fayettevill, GA","Folkston, GA","Forest Park, GA","Gainesville, GA","Hinesville, GA","Kathleen, GA","Kennesaw, GA","Lawrenceville, GA","Leesburg, GA","Loganville, GA","Macon, GA","Marietta, GA","Moultrie, GA","Newnan, GA","Peachtree City, GA","Perry, GA","Pooler, GA","Rincon, GA","Rome, GA","Savannah, GA","Smyrna, GA","Snellville, GA","Statesboro, GA","Stone Mountain, GA","Suwanee, GA","Thomasville, GA","Toccoa Falls, GA","Valdosta, GA","Vidalia, GA","Villa Rica, GA","Warner Robins, GA","Waycross, GA","Winder, GA","Woodbine, GA","Woodstock, GA","Young Harris, GA","Hilo, HI","Honolulu, HI","Kahului, HI","Kailua, HI","Kaneohe, HI","Kaunakakai, HI","Lahaina, HI","Lihue, HI","Makakilo, HI","Maui, HI","Pearl City, HI","Pukalani, HI","Waikiki, HI","Wailuku, HI","Waipahu, HI","Ames, IA","Ankeny, IA","Burlington, IA","Cedar Rapids, IA","Chariton, IA","Clinton, IA","Davenport, IA","Decorah, IA","Denison, IA","Des Moines, IA","Dubuque, IA","Emmetsburg, IA","Fairfield, IA","Fort Dodge, IA","Fort Madison, IA","Iowa City, IA","Iowa Falls, IA","Lake View, IA","Muscatine, IA","Oelwein, IA","Ottumwa, IA","Sheldon, IA","Shenandoah, IA","Sioux City, IA","Waterloo, IA","Waverly, IA","Blackfoot, ID","Boise, ID","Burley, ID","Challis, ID","Coeur d'Alene, ID","Hailey, ID","Idaho Falls, ID","Lewiston, ID","Moscow, ID","Pocatello, ID","Sandpoint, ID","Sun Valley, ID","Twin Falls, ID","Alton, IL","Arlington Heights, IL","Athens, IL","Aurora, IL","Barrington, IL","Batavia, IL","Beach park, IL","Belleville, IL","Belvidere, IL","Bloomington, IL","Bolingbrook, IL","Bourbonnais, IL","Buffalo Grove, IL","Cairo, IL","Campton Hills, IL","Carbondale, IL","Champaign, IL","Chicago, IL","Collinsville, IL","Crystal Lake, IL","Decatur, IL","Deerfield, IL","DeKalb, IL","Des Plaines, IL","Dixon, IL","Downers Grove, IL","Dwight, IL","East St Louis, IL","Edwardsville, IL","Effingham, IL","Evanston, IL","Franklin Park, IL","Galesburg, IL","Geneva, IL","Good Hope, IL","Havana, IL","Herrin, IL","Highland, IL","Hinsdale, IL","Hoffman Estates, IL","Jerseyville, IL","Kewwannee, IL","La Grange Park, IL","Lemont, IL","Libertyville, IL","Lisle, IL","Lockport, IL","Lombard, IL","Lyons, IL","Marion, IL","Marshall, IL","McHenry, IL","Moline, IL","Mundelein, IL","Naperville, IL","Normal, IL","North Aurora, IL","O'Fallon, IL","Oak Park, IL","Peoria, IL","Pittsfield, IL","Plainfield, IL","Prophetstown, IL","Quincy, IL","Robinson, IL","Rochester, IL","Rock Falls, IL","Rock Island, IL","Rockford, IL","Saint Charles, IL","Schaumburg, IL","South Beloit, Il","Spring Valley, IL","Springfield, IL","Sterling, IL","Streamwood, IL","Streator, IL","Urbana, IL","Vernon Hills, IL","Watseka, IL","Waukegan, IL","West Dundee, IL","West Frankfort, IL","Wheaton, IL","Woodstock, IL","Yorkville, IL","Zion, IL","Anderson, IN","Angola, IN","Argos, IN","Bloomington, IN","Brownsburg, IN","Clarksville, IN","Columbus, IN","Crawfordsville, IN","Crown Point, IN","Dale, IN","East Chicago, IN","Elkhart, IN","Evansville, IN","Fort Wayne, IN","Fowler, IN","Greenfield, IN","Greenwood, IN","Indianapolis, IN","Jasper, IN","Jeffersonville, IN","Kokomo, IN","La Porte, IN","Lafayette, IN","Merrillville, IN","Michigan City, IN","Mitchell, IN","Muncie, IN","New Castle, IN","Plymouth, IN","Salem, IN","Schererville, IN","South Bend, IN","Terre Haute, IN","Valparaiso, IN","West Lafayette, IN","Winamac, IN","Chanute, KS","Colby, KS","Dodge City, KS","Fort Scott, KS","Hays, KS","Howard, KS","Hugoton, KS","Junction City, KS","Kansas City, KS","Lawrence, KS","Leawood, KS","Manhattan, KS","Mulvane, KS","Overland Park, KS","Paola, KS","Parsons, KS","Salina, KS","Spearville, KS","Topeka, KS","Wichita, KS","Arlington, KY","Bowling Green, KY","Bremen, KY","Burlington, KY","Cadiz, KY","Campbellsville, KY","Corbin, KY","Edgewood, KY","Elizabethtown, KY","Erlanger, KY","Florence, KY","Georgetown, KY","Hazard, KY","Lebanon, KY","Lexington, KY","London, KY","Louisville, KY","Maysville, KY","Middlesborough, KY","Morehead, KY","Owensboro, KY","Paducah, KY","Paris, KY","Pikeville, KY","Radcliff, KY","Richmond, KY","Scottsville, KY","Somerset, KY","Williamsburg, KY","Alexandria, LA","Baton Rouge, LA","Benton, LA","Bossier City, LA","Covington, LA","Gonzales, LA","Hammond, LA","Houma, LA","Jonesboro, LA","Lafayette, LA","Lake Charles, LA","Leesville, LA","Mandeville, LA","Minden, LA","Monroe, LA","Morgan City, LA","New Iberia, LA","New Orleans, LA","Shreveport, LA","Slidell, LA","Ville Platte, LA","West Monroe, LA","Abington, MA","Acton, MA","Allston, MA","Amherst, MA","Andover, MA","Ashland, MA","Attleboro, MA","Barnstable, MA","Bedford, MA","Beverly, MA","Boston, MA","Bourne, MA","Burlington, MA","Cambridge, MA","Canton, MA","Chelsea, MA","Dedham, MA","Everett, MA","Fall River, MA","Falmouth, MA","Framingham, MA","Gloucester, MA","Great Barrington, MA","Greenfield, MA","Hanscom AFB, MA","Haverhill, MA","Hyannis, MA","Kingston, MA","Lawrence, MA","Leominster, MA","Lexington, MA","Longmeadow, MA","Lowell, MA","Lunenburg, MA","Malden, MA","Marlborough, MA","Martha's Vineyard, MA","Medford, MA","Nantucket, MA","Natick, MA","Needham, MA","New Bedford, MA","Newton, MA","North Andover, MA","North Attleborough, MA","Northampton, MA","Pittsfield, MA","Provincetown, MA","Saugus, MA","Somerville, MA","South Hadley, MA","South Yarmouth, MA","Southbridge, MA","Springfield, MA","Swampscott, MA","Taunton, MA","Tewksbury, MA","Wakefield, MA","Westborough, MA","Westfield, MA","Williamstown, MA","Woburn, MA","Worcester, MA","Abingdon, MD","Annapolis, MD","Baltimore, MD","Bethesda, MD","Bowie, MD","California, MD","Catonsville, MD","Chevy Chase, MD","College Park, MD","Columbia, MD","Cumberland, MD","Easton, MD","Eldersburg, MD","Ellicott City, MD","Frederick, MD","Frostburg, MD","Gaithersburg, MD","Germantown, MD","Hagerstown, MD","Hunt Valley, MD","Hyattsville, MD","Laurel, MD","Lexington Park, MD","North East, MD","Parkville, MD","Rockville, MD","Salisbury, MD","Severna Park, MD","Silver Spring, MD","Temple Hills, MD","Upper Marlboro, MD","Waldorf, MD","Westminster, MD","Athens, ME","Augusta, ME","Bangor, ME","Bar Harbor, ME","Brunswick, ME","Cumberland, ME","Eliot, ME","Ellsworth, ME","Fairfield, ME","Lewiston, ME","Lincolnville, ME","Mechanic Falls, ME","Millinocket, ME","Portland, ME","Presque Isle, ME","South Portland, ME","Stockholm, ME","Topsham, ME","Vassalboro, ME","Whitefield, ME","Adrian, MI","Allegan, MI","Alpena, MI","Ann Arbor, MI","Battle Creek, MI","Big Rapids, MI","Bloomfield Hills, MI","Cadillac, MI","Cheboygan, MI","Chesterfield, MI","Clarkton, MI","Clinton Township, MI","Coldwater, MI","Commerce, MI","Detroit, MI","East Lansing, MI","Eastpointe, MI","Farmington Hills, MI","Flint, MI","Fowlerville, MI","Garden City, MI","Gaylord, MI","Grand Rapids, MI","Grosse Pointe Woods, MI","Harper Woods, MI","Hazel Park, MI","Hell, MI","Highland Charter Township, MI","Holland, MI","Houghton, MI","Huntington Woods, MI","Kalamazoo, MI","Lake Orion, MI","Lansing, MI","Livonia, MI","Macomb, MI","Madison Heights, MI","Manistee, MI","Marquette, MI","Midland, MI","Millington, MI","Monroe, MI","Mount Pleasant, MI","Muskegon, MI","Niles, MI","Novi, MI","Ocean Springs, MI","Ortonville, MI","Owosso, MI","Pinconning, MI","Plymouth, MI","Pontiac, MI","Port Huron, MI","River Rouge, MI","Rochester, MI","Rockford, MI","Rogers City, MI","Saginaw, MI","Saint Johns, MI","Saint Joseph, MI","Shelby Township, MI","Southfield, MI","Sterling Heights, MI","Traverse City, MI","Troy, MI","Warren, MI","Waterford, MI","White Lake Township, MI","Wixom, MI","Wyandotte, MI","Yale, MI","Ypsilanti, MI","Zeeland, MI","Albert Lea, MN","Alexandria, MN","Andover, MN","Apple Valley, MN","Bemidji, MN","Brainerd, MN","Buffalo, MN","Burnsville, MN","Cannon Falls, MN","Cloquet, MN","Coon Rapids, MN","Crookston, MN","Deer River, MN","Detroit Lakes, MN","Duluth, MN","Eden Prairie, MN","Hopkins, MN","Hutchinson, MN","International Falls, MN","Isanti, MN","Janesville, MN","Kenyon, MN","Lakeville, MN","Mankato, MN","Marshall, MN","Minneapolis, MN","Mound, MN","Northfield, MN","Proctor, MN","Redwood Falls, MN","Richfield, MN","Rochester, MN","Roseau, MN","Saint Cloud, MN","Saint Paul, MN","St. Cloud, MN","Staples, MN","Stillwater, MN","Thief River Falls, MN","Vadnais Heights, MN","Willmar, MN","Winona, MN","Branson, MO","Brookfield, MO","Camdenton, MO","Cape Girardeau, MO","Carthage, MO","Chesterfield, MO","Chillicothe, MO","Clayton, MO","Columbia, MO","Eldon, MO","Ellsinore, MO","Farmington, MO","Hannibal, MO","High Ridge, MO","Houston, MO","Independence, MO","Jefferson City, MO","Joplin, MO","Kansas City, MO","Kirksville, MO","Liberty, MO","Lincoln, MO","Macon, MO","Maryville, MO","Moberly, MO","Neosho, MO","O'Fallon, MO","Poplar Bluff, MO","Portageville, MO","Saint Charles, MO","Saint Joseph, MO","Saint Louis, MO","Sedalia, MO","Springfield, MO","Versailles, MO","Waynesville, MO","Webb City, MO","West Plains, MO","Batesville, MS","Biloxi, MS","Clinton, MS","Ellisville, MS","Gulfport, MS","Hattiesburg, MS","Jackson, MS","Laurel, MS","Lucedale, MS","Meridian, MS","Moss Point, MS","Olive Branch, MS","Oxford, MS","Pass Christian, MS","Pontotoc, MS","Poplarville, MS","Southaven, MS","Starkville, MS","Tupelo, MS","Woodville, MS","Anaconda, MT","Billings, MT","Bozeman, MT","Butte, MT","Forsyth, MT","Glasgow, MT","Great Falls, MT","Hamilton, MT","Helena, MT","Kalispell, MT","Lewistown, MT","Libby, MT","Missoula, MT","Polson, MT","Townsend, MT","Zurich, MT","Albemarle, NC","Asheville, NC","Ballentine, NC","Boone, NC","Brevard, NC","Burnsville, NC","Candor, NC","Cape Carteret, NC","Cary, NC","Chapel Hill, NC","Charlotte, NC","Concord, NC","Cornelius, NC","Durham, NC","Elizabeth City, NC","Elizabethtown, NC","Fayetteville, NC","Forest City, NC","Fort Bragg, NC","Franklin, NC","Gastonia, NC","Goldsboro, NC","Greensboro, NC","Greenville, NC","Hickory, NC","High Point, NC","Highlands, NC","Holly Springs, NC","Hope Mills, NC","Jacksonville, NC","Jamesville, NC","Kenansville, NC","Kernersville, NC","Kinston, NC","Knightdale, NC","Lumberton, NC","Mill Spring, NC","Mooresville, NC","Nags Head, NC","New Bern, NC","Oxford, NC","Pinehurst, NC","Raleigh, NC","Rocky Mount, NC","Roxboro, NC","Sanford, NC","Shelby, NC","Spruce Pine, NC","Stanfield, NC","Sylva, NC","Washington, NC","Williamston, NC","Willow Spring, NC","Wilmington, NC","Winston-Salem, NC","Yanceyville, NC","Bismarck, ND","Dickinson, ND","Fargo, ND","Grand Forks, ND","Jamestown, ND","Minot, ND","Williston, ND","Bellevue, NE","Chadron, NE","Columbus, NE","Crete, NE","De Witt, NE","Grand Island, NE","Hastings, NE","Kearney, NE","Lexington, NE","Lincoln, NE","North Platte, NE","Omaha, NE","Sidney, NE","Canaan, NH","Claremont, NH","Concord, NH","Derry, NH","Dover, NH","Hanover, NH","Holderness, NH","Keene, NH","Lisbon, NH","Littleton, NH","Manchester, NH","Nashua, NH","Portsmouth, NH","Rochester, NH","Salem, NH","Township of Dixville, NH","Allendale, NJ","Atlantic City, NJ","Barnegat, NJ","Basking Ridge, NJ","Bayonne, NJ","Beach Haven, NJ","Bedminster Township, NJ","Bergen County, NJ","Berkeley Heights, NJ","Bloomfield, NJ","Bridgeton, NJ","Bridgewater, NJ","Browns Mills, NJ","Camden, NJ","Cape May Court House, NJ","Cherry Hill, NJ","Chesilhurst, NJ","Clifton, NJ","Clinton, NJ","Cranford, NJ","Dunellen, NJ","East Orange, NJ","East Rutherford, NJ","Eatontown, NJ","Edison, NJ","Flanders, NJ","Flemington, NJ","Fort Lee, NJ","Freehold, NJ","Harrington Park, NJ","Ho-Ho-Kus, NJ","Hoboken, NJ","Jackson, NJ","Jersey City, NJ","Lakewood Township, NJ","Lanoka Harbor, NJ","Long Branch, NJ","Manahawkin, NJ","Manalapan Township, NJ","Manchester Township, NJ","Metuchen, NJ","Middlesex, NJ","Middletown, NJ","Montclair, NJ","Morristown, NJ","Mount Laurel, NJ","Mullica Hill, NJ","Newark, NJ","Newton, NJ","North Brunswick, NJ","Parsippany-Troy Hills, NJ","Passaic, NJ","Paterson, NJ","Perth Amboy, NJ","Plainsboro, NJ","Princeton, NJ","Red Bank, NJ","Ridgewood, NJ","Riverdale, NJ","Rutherford, NJ","Saddle Brook, NJ","Scotch Plains, NJ","Seaside Heights, NJ","Somerset, NJ","Spring Lake, NJ","Springfield, NJ","Summit, NJ","Teaneck, NJ","Toms River, NJ","Trenton, NJ","Vernon, NJ","Vineland, NJ","Warren, NJ","Wesfield, NJ","West Caldwell, NJ","West Deptford, NJ","West New York, NJ","West Orange, NJ","Willingboro, NJ","Woodbridge, NJ","Clovis, NM","Alamogordo, NM","Albuquerque, NM","Belen, NM","Bernalillo, NM","Carlsbad, NM","Edgewood, NM","Farmington, NM","Hobbs, NM","Las Cruces, NM","Los Alamos, NM","Rio Rancho, NM","Ruidoso, NM","Santa Fe, NM","Taos, NM","Amargosa Valley, NV","Boulder City, NV","Carson City, NV","Dayton, NV","Elko, NV","Gardnerville, NV","Henderson, NV","Las Vegas, NV","Los Santos, NV","Mesquite, NV","Paradise, NV","Reno, NV","Winnemucca, NV","Albany, NY","Amenia, NY","Amherst, NY","Amityville, NY","Astoria, NY","Ballston, NY","Bath, NY","Binghamton, NY","Bronx, NY","Brookhaven, NY","Brooklyn, NY","Buffalo, NY","Cedarhurst, NY","Central Valley, NY","Clifton Park, NY","Congers, NY","Corning, NY","East Hampton, NY","East Northport, NY","Elmira, NY","Farmingdale, NY","Farmingville, NY","Fishkill, NY","Fort Drum, NY","Garden City, NY","Geneva, NY","Glen Cove, NY","Greene, NY","Greenwich, NY","Hempstead, NY","Hilton, NY","Hoosick Falls, NY","Hornell, NY","Islip, NY","Ithaca, NY","Kings Park, NY","Kingston, NY","Levittown, NY","Livingston Manor, NY","Long Island, NY","Massapequa, NY","Massapequa Park, NY","Massena, NY","Medford, NY","Mount Vernon, NY","New City, NY","New Paltz, NY","New Rochelle, NY","New Windsor, NY","New York, NY","Niagara Falls, NY","Norwich, NY","Oceanside, NY","Oswego, NY","Oyster Bay, NY","Pawling, NY","Peekskill, NY","Plattsburgh, NY","Pleasantville, NY","Port Jefferson Station, NY","Poughkeepsie, NY","Queens, NY","Queensbury, NY","Rochester, NY","Rocky Point, NY","Rome, NY","Ronkonkoma, NY","Saratoga Springs, NY","Sayville, NY","Schenectady, NY","Selden, NY","Seneca Falls, NY","Sinclairville, NY","Smithtown, NY","Southampton, NY","Staten Island, NY","Syracuse, NY","Troy, NY","Utica, NY","Waccabuc, NY","Walden, NY","Watertown, NY","Watkins Glen, NY","Wayland, NY","Webster, NY","West Chazy, NY","Westhampton Beach, NY","White Plains, NY","Woodbury, NY","Woodstock, NY","Yonkers, NY","Akron, OH","Alliance, OH","Ashland, OH","Athens, OH","Batavia, OH","Bluffton, OH","Bowling Green, OH","Brecksville, OH","Brewster, OH","Cambridge, OH","Canton, OH","Celina, OH","Chillicothe, OH","Cincinnati, OH","Cleveland, OH","Columbus, OH","Conneaut, OH","Dayton, OH","Delaware, OH","Dennison, OH","Dover, OH","Dublin, OH","Fairborn, OH","Gnadenhutten, OH","Hamilton, OH","Howard, OH","Ironton, OH","Kent, OH","Kidron, OH","Lebanon, OH","Lewis Center, OH","Lima, OH","London, OH","Mansfield, OH","Medina, OH","Mentor, OH","Middletown, OH","New Albany, OH","Newton Falls, OH","Parma, OH","Perrysburg, OH","Portsmouth, OH","Rushsylvania, OH","Sandusky, OH","Solon, OH","Springfield, OH","Sylvania, OH","Tiffin, OH","Toledo, OH","Twinsburg, OH","Wadsworth, OH","Wauseon, OH","Westerville, OH","Wickliffe, OH","Willoughby, OH","Wilmington, OH","Wooster, OH","Worthington, OH","Yellow Springs, OH","Youngstown, OH","Zanesville, OH","Ada, OK","Ardmore, OK","Bartlesville, OK","Claremore, OK","Durant, OK","Edmond, OK","Lawton, OK","Lindsay, OK","McAlester, OK","Muskogee, OK","Norman, OK","Oklahoma City, OK","Owasso, OK","Ponca City, OK","Shawnee, OK","Stillwater, OK","Tahlequah, OK","Tecumseh, OK","Tulsa, OK","Yukon, OK","Woodward, OK","Toronto, ON","Albany, OR","Astoria, OR","Baker City, OR","Beaverton, OR","Bend, OR","Burns, OR","Coos Bay, OR","Corvallis, OR","Eugene, OR","Fairview, OR","Gold Beach, OR","Grants Pass, OR","Gresham, OR","Hermiston, OR","Hillsboro, OR","Klamath Falls, OR","Medford, OR","Milwaukie, OR","Newport, OR","Pendleton, OR","Portland, OR","Prineville, OR","Roseburg, OR","Salem, OR","Seaside, OR","Springfield, OR","The Dalles, OR","Tualtin, OR","Woodburn, OR","Albrightsville, PA","Allentown, PA","Ambler, PA","Bethlehem, PA","Bloomsburg, PA","Bradford, PA","Carlisle, PA","Chester, PA","Chesterbrook, PA","Clarion, PA","Clearfield, PA","Cranberry Township, PA","Croydon, PA","Downingtown, PA","Doylestown, PA","East Freedom, PA","Elkland, PA","Erdenheim, PA","Erie, PA","Ford City, PA","Gettysburg, PA","Greensburg, PA","Greenville, PA","Hamburg, PA","Harrisburg, PA","Honesdale, PA","Huntingdon, PA","Indiana, PA","Johnstown, PA","Lancaster, PA","Lansdale, PA","Levittown, PA","Lewisburg, PA","Lock Haven, PA","Malvern, PA","Meadville, PA","Mechanicsburg, PA","Media, PA","Milford, PA","Minersville, PA","Morrisville, PA","Mount Pleasant, PA","New Castle, PA","New Eagle, PA","North Wales, PA","Oxford, PA","Patton, PA","Perkasie, PA","Philadelphia, PA","Pittsburgh, PA","Pottsville, PA","Reading, PA","Richboro, PA","Ridley Park, PA","Rochester, PA","Royersford, PA","Scranton, PA","Selinsgrove, PA","Sewickley, PA","Shamokin, PA","Shippensburg, PA","State College, PA","Stroudsburg, PA","Telford, PA","Towanda, PA","Warren, PA","Wayne, PA","Waynesboro, PA","West Chester, PA","Wilkes-Barre, PA","Williamsport, PA","Willow Grove, PA","Wyomissing, PA","Yardley, PA","York, PA","Malone, QC","Coventry, RI","East Providence, RI","Newport, RI","Pawtucket, RI","Providence, RI","Wakefield-Peacedale, RI","West Greenwich, RI","West Warwick, RI","Woonsocket, RI","Anderson, SC","Beaufort, SC","Belton, SC","Charleston, SC","Columbia, SC","Cowpens, SC","Florence, SC","Goose Creek, SC","Greenville, SC","Hilton Head Island, SC","Ladson, SC","Lancaster, SC","Moncks Corner, SC","Mount Pleasant, SC","Myrtle Beach, SC","North Charleston, SC","Pendleton, SC","Rock Hill, SC","Simpsonville, SC","Spartanburg, SC","Summerville, SC","Sumter, SC","Tega Cay, SC","York, SC","Aberdeen, SD","Lemmon, SD","Pierre, SD","Rapid City, SD","Rosholt, SD","Sioux Falls, SD","Vermillion, SD","Watertown, SD","Athens, TN","Bartlett, TN","Brentwood, TN","Chattanooga, TN","Clarksville, TN","Cookeville, TN","Ducktown, TN","Dyersburg, TN","Elizabethton, TN","Franklin, TN","Gatlinburg, TN","Germantown, TN","Harriman, TN","Harrogate, TN","Jacksboro, TN","Jackson, TN","Johnson City, TN","Kingsport, TN","Knoxville, TN","Lawrenceburg, TN","Lewisburg, TN","Manchester, TN","Martin, TN","Memphis, TN","Morristown, TN","Murfreesboro, TN","Nashville, TN","Oak Ridge, TN","Oakland, TN","Sevierville, TN","Spring Hill, TN","Tullahoma, TN","Whitwell, TN","Abilene, TX","Allen, TX","Alpine, TX","Amarillo, TX","Arlington, TX","Austin, TX","Balch Springs, TX","Baytown, TX","Beaumont, TX","Beeville, TX","Big Spring, TX","Brenham, TX","Brownsville, TX","Caldwell, TX","College Station, TX","Conroe, TX","Corpus Christi, TX","Dallas, TX","Del Rio, TX","Denton, TX","Dublin, TX","Eagle, TX","El Paso, TX","Forney, TX","Fort Worth, TX","Fred, TX","Frisco, TX","Galveston, TX","Garland, TX","Glen Rose, TX","Granbury, TX","Grapevine, TX","Greenville, TX","Harlingen, TX","Houston, TX","Huntington, TX","Huntsville, TX","Irving, TX","Katy, TX","Keller, TX","Kerrville, TX","Killeen, TX","Laredo, TX","Leander, TX","Lewisville, TX","Livingston, TX","Llano, TX","Longview, TX","Lubbock, TX","Mansfield, TX","Marble Falls, TX","Marshall, TX","McAllen, TX","McKinney, TX","Mesquite, TX","Midland, TX","Mission, TX","Mount Pleasant, TX","Nacogdoches, TX","New Braunfels, TX","Odessa, TX","Palestine, TX","Paris, TX","Plano, TX","Pottsboro, TX","Ranger, TX","Rockdale, TX","San Angelo, TX","San Antonio, TX","San Marcos, TX","Seagoville, TX","Seven Points, TX","Shepherd, TX","Sherman, TX","Sugar Land, TX","Sulphur Springs, TX","Taylor, TX","Temple, TX","Texarkana, TX","The Woodlands, TX","Tyler, TX","Valley View, TX","Victoria, TX","Waco, TX","Weatherford, TX","Weslaco, TX","Whitney, TX","Wichita Falls, TX","Wickett, TX","Wylie, TX","Breckenridge, TX","Stephenville, TX","Cedar City, UT","Centerville, UT","Coalville, UT","Farmington, UT","Lehi, UT","Logan, UT","Mapleton, UT","Moab, UT","Monticello, UT","Ogden, UT","Orem, UT","Park City, UT","Payson, UT","Price, UT","Riverton, UT","Roy, UT","Saint George, UT","Salt Lake City, UT","Spanish Fork, UT","Tooele, UT","Alexandria, VA","Amherst, VA","Appomattox, VA","Arlington, VA","Ashburn, VA","Blacksburg, VA","Bristol, VA","Cape Charles, VA","Centreville, VA","Chantilly, VA","Charlottesville, VA","Chesapeake, VA","Christiansburg, VA","Danville, VA","Elkton, VA","Fairfax, VA","Farmville, VA","Floyd, VA","Fredericksburg, VA","Gainesville, VA","Galax, VA","Hampton, VA","Herndon, VA","Leesburg, VA","Lynchburg, VA","Manassas, VA","Marion, VA","Martinsville, VA","McLean, VA","Midlothian, VA","Newport News, VA","Norfolk, VA","Reston, VA","Richmond, VA","Roanoke, VA","Round Hill, VA","South Riding, VA","Springfield, VA","Staunton, VA","Strasburg, VA","Topping, VA","Verona, VA","Virginia Beach, VA","Warrenton, VA","Waynesboro, VA","Williamsburg, VA","Winchester, VA","Woodbridge, VA","Woodstock, VA","Yorktown, VA","Brandon, VT","Brattleboro, VT","Burlington, VT","Montpelier, VT","Rutland, VT","Saint Albans, VT","Springfield, VT","St. Albans Town, VT","Aberdeen, WA","Airway Heights, WA","Algona, WA","Arlington, WA","Auburn, WA","Bainbridge Island, WA","Bellevue, WA","Bellingham, WA","Blaine, WA","Bothell, WA","Bremerton, WA","Brier, WA","Buckley, WA","Bucoda, WA","Centralia, WA","Chehalis, WA","Chelan, WA","Cle Elum, WA","DuPont, WA","Duvall, WA","East Wenatchee, WA","Eastsound, WA","Electric City, WA","Ellensburg, WA","Enumclaw, WA","Everett, WA","Forks, WA","Gig Harbor, WA","Grand Coulee, WA","Grandview, WA","Issaquah, WA","Kelso, WA","Kenmore, WA","Kennewick, WA","Kent, WA","Kingston, WA","Lacey, WA","Lakewood, WA","Langley, WA","Leavenworth, WA","Littlerock, WA","Longview, WA","Malott, WA","Maytown, WA","Moses Lake, WA","Mount Vernon, WA","North Bend, WA","Ocean Shores, WA","Olympia, WA","Pasco, WA","Port Hadlock, WA","Poulsbo, WA","Pullman, WA","Puyallup, WA","Redmond, WA","Renton, WA","Richland, WA","Rochester, WA","SeaTac, WA","Seattle, WA","Sequim, WA","Shoreline, WA","Spokane, WA","Tacoma, WA","Tenino, WA","Tukwila, WA","Tumwater, WA","Union Gap, WA","University Place, WA","Vancouver, WA","Walla Walla, WA","Wenatchee, WA","Whidbey Island, WA","Woodinville, WA","Woodland, WA","Yakima, WA","Yelm, WA","Zillah, WA","Sandersville, WA","Appleton, WI","Ashland, WI","Baraboo, WI","Beaver Dam, WI","Beloit, WI","Cedarburg, WI","Eau Claire, WI","Elkhorn, WI","Fennimore, WI","Fond du Lac, WI","Fort Atkinson, WI","Germantown, WI","Grafton, WI","Green Bay, WI","Janesville, WI","Kenosha, WI","La Crosse, WI","Lake Geneva, WI","Madison, WI","Marshfield, WI","Merrill, WI","Milwaukee, WI","Neenah, WI","Neillsville, WI","New Richmond, WI","Oconto Falls, WI","Osceola, WI","Oshkosh, WI","Rhinelander, WI","Rice Lake, WI","Ripon, WI","River Falls, WI","Sheboygan, WI","Stevens Point, WI","Superior, WI","Thiensville, WI","Waukesha, WI","Waunakee, WI","Wausau, WI","Wauwatosa, WI","West Allis, WI","Wisconsin Dells, WI","Beckley, WV","Bluefield, WV","Charles Town, WV","Charleston, WV","Clarksburg, WV","Clay County, WV","Elkins, WV","Fairmont, WV","Harpers Ferry, WV","Huntington, WV","Kingwood, WV","Martinsburg, WV","Morgantown, WV","Parkersburg, WV","Ravenswood, WV","Shepherdstown, WV","Summersville, WV","Weirton, WV","Welch, WV","Wheeling, WV","Basin, WY","Casper, WY","Cheyenne, WY","Cody, WY","Evanston, WY","Gillette, WY","Jackson, WY","Lander, WY","Laramie, WY","Pinedale, WY","Rock Springs, WY","Sheridan, WY","Sinclair, WY","Worland, WY"
    };
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