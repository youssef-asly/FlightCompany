# FlightCompany
Flight app services that handles:Check if ticket is available,Provide baggage check in service andProvide Coupon support
Flight app services that handles the following requests:
Prerequisites:
Create hardcoded data that will “act” as your datasource (no need to run external/internal databases).

write an API that provides the following functionality:
a. Check if ticket is available
  a1. User Provide TicketId(Numeric) and return response (boolean) whether the ticket is available or not (the response will determine upon your predefined static data).
b. Provide baggage check in service
  b1. User provide Destination Id(Numeric) and baggage Id(String)
  b2. Return answer if the checkin succeeded (boolean)
c. Provide Coupon support.
  c1. User provide couponId(Numeric) and Price(Double)
  c2. Return response if the coupon is valid. In the response the use will get the final price after discount (10%,50%,60% - picked up randomly) in case not valid the response 
   should indicate that the coupon is not valid and the original price will be returned * create random list of valid couponId's
d. Create a local in-memory cache mechanism that caching results and add expiration to them.
