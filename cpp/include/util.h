/*****************************************
 * This file is documented for Doxygen.
 * If you modify this file please update
 * the comments so that Doxygen will still
 * be able to work.
 ****************************************/
#ifndef PROCESSING_UTIL_H
#define PROCESSING_UTIL_H

#include <rapidjson/document.h>
#include <rapidjson/writer.h>
#include <rapidjson/stringbuffer.h>

#include <exception>
#include <string>

/**
 * @namespace processingformats
 * The namespace containing a collection of classes and functions that
 * convert to/from the USGS json processing formats.
 */
namespace processingformats {
	/**
	 * \brief detectionformats function to validate that a string contains just
	 * characters
	 */
	bool IsStringAlpha(const std::string &s);

	/**
	 * \brief detectionformats function to validate that a string contains an
	 * iso8601 time
	 */
	bool IsStringISO8601(const std::string &s);

	/**
	 * \brief Convert iso8601 time string to decimal epoch seconds
	 *
	 * Converts the provided iso8601 string to decimal epoch seconds
	 * \return Returns a double containing the decimal epoch seconds
	 */
	double ConvertISO8601ToEpochTime(std::string TimeString);

	/**
	 * \brief Convert decimal epoch seconds to iso8601 time string
	 *
	 * Converts the  decimal epoch seconds to iso8601 time string
	 * \return Returns a std::string containing iso8601 time string
	 */
	std::string ConvertEpochTimeToISO8601(double epochtime);

	/**
	 * \brief Convert to json string function
	 *
	 * Converts the contents of the class to a serialized json string
	 * \return Returns a std::string containing the serialized json string
	 */
	std::string ToJSONString(rapidjson::Value &json); // NOLINT

	/**
	 * \brief Convert from json string function
	 *
	 * Converts the provided string from a serialized json string, populating
	 * members
	 * \param jsonstring - A std::string containing the serialized json
	 * \return Returns 1 if successful, 0 otherwise
	 */
	rapidjson::Document & FromJSONString(std::string jsonstring,
										 rapidjson::Document & jsondocument); // NOLINT

}  // namespace processingformats
#endif  // PROCESSING_UTIL_H
