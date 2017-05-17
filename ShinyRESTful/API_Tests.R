# Title: Example of Calling a RESTful API
# Description:
#   Example Queries
#
# Author: Dan Dixey (QbizUK)
# Created: 14/1/2017
# Updated: 17/5/2017
#

# Function to check if packages are installed ---------------------
library(httr)
library(jsonlite)

# Check the API is Running ----------------------------------------
r <- GET("http://localhost:8080")
str(content(r))

# Pull from URL (GET) ---------------------------------------------
get_API <- function(url) {
  df <- fromJSON(url)
  json_data_frame <- df$payload
  json_data_frame
}
rock = get_API("http://localhost:8080/data/rocks")
pressure = get_API("http://localhost:8080/data/pressure")
cars = get_API("http://localhost:8080/data/cars")

# Send data (PUT) ------------------------------------------------
name = "Dan!"
body <- list(data = list(name = name))
r <- POST(url = "http://localhost:8080/message", body = body, 
          encode = "json", verbose())
output <- content(r, "parsed")$Message
output
