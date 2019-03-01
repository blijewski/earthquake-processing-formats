package gov.usgs.processingformats;

import java.util.ArrayList;

import org.json.simple.*;

/**
 * a conversion class used to create, parse, and validate site data as part of
 * processing data.
 *
 * @author U.S. Geological Survey &lt;jpatton at usgs.gov&gt;
 */
public class Site implements ProcessingInt {
	/**
	 * JSON Keys
	 */
	public static final String STATION_KEY = "Station";
	public static final String CHANNEL_KEY = "Channel";
	public static final String NETWORK_KEY = "Network";
	public static final String LOCATION_KEY = "Location";
	public static final String LATITUDE_KEY = "Latitude";
	public static final String LONGITUDE_KEY = "Longitude";
	public static final String ELEVATION_KEY = "Elevation";	

	/**
	 * Required station code.
	 */
	private String station;

	/**
	 * Optional network/component code.
	 */
	private String channel;

	/**
	 * Required network code.
	 */
	private String network;

	/**
	 * Optional location code.
	 */
	private String location;

	/**
	 * Required Double containing the latitude
	 */
	private Double latitude;

	/**
	 * Required Double containing the longitude
	 */
	private Double longitude;

	/**
	 * Required Double containing the elevation
	 */
	private Double elevation;

	/**
	 * The constructor for the Site class. Initializes members to null values.
	 */
	public Site() {
		station = null;
		channel = null;
		network = null;
		location = null;
		latitude = null;
		longitude = null;
		elevation = null;
	}

	/**
	 * The alternate advanced constructor for the Site class. Initializes
	 * members to provided values.
	 *
	 * @param newStation
	 *            - A String containing the station to use
	 * @param newChannel
	 *            - A String containing the channel to use (null omit)
	 * @param newNetwork
	 *            - A String containing the network to use
	 * @param newLocation
	 *            - A String containing the location to use (null omit)
	 * @param newLatitude
	 *            - A Double containing the latitude to use
	 * @param newLongitude
	 *            - A Double containing the longitude to use
	 * @param newElevation
	 *            - A Double containing the elevation to use
	 */
	public Site(String newStation, String newChannel, String newNetwork,
			String newLocation, Double newLatitude, Double newLongitude,
			Double newElevation) {

		reload(newStation, newChannel, newNetwork, newLocation, newLatitude, 
			newLongitude, newElevation);
	}

	/**
	 * Reload Function
	 *
	 * The reload function for the site class. Initializes members to provided
	 * values.
	 *
	 * @param newStation
	 *            - A String containing the station to use
	 * @param newChannel
	 *            - A String containing the channel to use (null omit)
	 * @param newNetwork
	 *            - A String containing the network to use
	 * @param newLocation
	 *            - A String containing the location to use (null omit)
	 * @param newLatitude
	 *            - A Double containing the latitude to use
	 * @param newLongitude
	 *            - A Double containing the longitude to use
	 * @param newElevation
	 *            - A Double containing the elevation to use
	 */
	public void reload(String newStation, String newChannel, String newNetwork,
			String newLocation, Double newLatitude, Double newLongitude,
			Double newElevation) {
		station = newStation;
		channel = newChannel;
		network = newNetwork;
		location = newLocation;
		latitude = newLatitude;
		longitude = newLongitude;
		elevation = newElevation;
	}

	/**
	 * Constructs the class from a JSONObject, populating members
	 *
	 * @param newJSONObject
	 *            - A JSONObject.
	 */
	public Site(JSONObject newJSONObject) {
		// required values
		// station
		if (newJSONObject.containsKey(STATION_KEY)) {
			station = newJSONObject.get(STATION_KEY).toString();
		} else {
			station = null;
		}

		// network
		if (newJSONObject.containsKey(NETWORK_KEY)) {
			network = newJSONObject.get(NETWORK_KEY).toString();
		} else {
			network = null;
		}

		// latitude
		if (newJSONObject.containsKey(LATITUDE_KEY)) {
			latitude = (double) newJSONObject.get(LATITUDE_KEY);
		} else {
			latitude = null;
		}

		// longitude
		if (newJSONObject.containsKey(LONGITUDE_KEY)) {
			longitude = (double) newJSONObject.get(LONGITUDE_KEY);
		} else {
			longitude = null;
		}

		// elevation
		if (newJSONObject.containsKey(ELEVATION_KEY)) {
			elevation = (double) newJSONObject.get(ELEVATION_KEY);
		} else {
			elevation = null;
		}		

		// optional values
		// channel
		if (newJSONObject.containsKey(CHANNEL_KEY)) {
			channel = newJSONObject.get(CHANNEL_KEY).toString();
		} else {
			channel = null;
		}

		// location
		if (newJSONObject.containsKey(LOCATION_KEY)) {
			location = newJSONObject.get(LOCATION_KEY).toString();
		} else {
			location = null;
		}
	}

	/**
	 * Converts the contents of the class to a JSONObject
	 *
	 * @return Returns a JSONObject containing the class contents
	 */
	@SuppressWarnings("unchecked")
	public JSONObject toJSON() {
		JSONObject NewJSONObject = new JSONObject();

		String jsonStation = getStation();
		String jsonNetwork = getNetwork();
		String jsonChannel = getChannel();
		String jsonLocation = getLocation();
		Double jsonLatitude = getLatitude();
		Double jsonLongitude = getLongitude();
		Double jsonElevation = getElevation();

		// required values
		// station
		if ((jsonStation != null) && (!jsonStation.isEmpty())) {
			NewJSONObject.put(STATION_KEY, jsonStation);
		}

		// network
		if ((jsonNetwork != null) && (!jsonNetwork.isEmpty())) {
			NewJSONObject.put(NETWORK_KEY, jsonNetwork);
		}

		// latitude
		if (jsonLatitude != null) {
			NewJSONObject.put(LATITUDE_KEY, jsonLatitude);
		}

		// longitude
		if (jsonLongitude != null) {
			NewJSONObject.put(LONGITUDE_KEY, jsonLongitude);
		}

		// elevation
		if (jsonElevation != null) {
			NewJSONObject.put(ELEVATION_KEY, jsonElevation);
		}

		// optional values
		// channel
		if ((jsonChannel != null) && (!jsonChannel.isEmpty())) {
			NewJSONObject.put(CHANNEL_KEY, jsonChannel);
		}

		// location
		if ((jsonLocation != null) && (!jsonLocation.isEmpty())) {
			NewJSONObject.put(LOCATION_KEY, jsonLocation);
		}

		// return valid object
		return (NewJSONObject);
	}

	/**
	 * Validates the class.
	 *
	 * @return Returns true if successful
	 */
	public boolean isValid() {
		if (getErrors() == null) {
			return (true);
		} else if (getErrors().size() == 0) {
			return (true);
		} else {
			return (false);
		}
	}

	/**
	 * Gets any validation errors in the class.
	 *
	 * @return Returns a List&lt;String&gt; of any errors found
	 */
	public ArrayList<String> getErrors() {
		String jsonStation = getStation();
		String jsonNetwork = getNetwork();
		Double jsonLatitude = getLatitude();
		Double jsonLongitude = getLongitude();
		Double jsonElevation = getElevation();

		ArrayList<String> errorList = new ArrayList<String>();

		// check for required keys
		// station
		if (jsonStation == null) {
			// station not found
			errorList.add("No Station in Site Class.");
		} else if (jsonStation.isEmpty()) {
			// station empty
			errorList.add("Empty Station in Site Class.");
		}

		// network
		if (jsonNetwork == null) {
			// network not found
			errorList.add("No Network in Site Class.");
		} else if (jsonNetwork.isEmpty()) {
			// network empty
			errorList.add("Empty Network in Site Class.");
		}

		// latitude
		if (jsonLatitude == null) {
			// latitude not found
			errorList.add("No Latitude in Site Class.");
		} else if ((jsonLatitude < -90) || (jsonLatitude > 90)) {
			// invalid latitude
			errorList.add(
					"Latitude in Site Class not in the range of -90 to 90.");
		}

		// longitude
		if (jsonLongitude == null) {
			// longitude not found
			errorList.add("No Longitude in Site Class.");
		} else if ((jsonLongitude < -180) || (jsonLongitude > 180)) {
			// invalid longitude
			errorList.add(
					"Longitude in Site Class not in the range of -180 to 180.");
		}

		// elevation
		if (jsonElevation == null) {
			// elevation not found
			errorList.add("No Elevation in Site Class.");
		}

		// since station, channel, network, and location are free text
		// strings, no further validation is required. channel and location
		// are also optional.
		// NOTE: Further validation COULD be done to confirm that values matched
		// seed standards.

		// success
		return (errorList);
	}

	/**
	 * @return the station
	 */
	public String getStation() {
		return station;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @return the network
	 */
	public String getNetwork() {
		return network;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @return the elevation
	 */
	public Double getElevation() {
		return elevation;
	}	

	/**
	 * @param station
	 *            the station to set
	 */
	public void setStation(String station) {
		this.station = station;
	}

	/**
	 * @param channel
	 *            the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @param network
	 *            the network to set
	 */
	public void setNetwork(String network) {
		this.network = network;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}	

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @param elevation
	 *            the elevation to set
	 */
	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}
}
