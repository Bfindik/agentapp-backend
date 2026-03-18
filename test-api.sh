#!/bin/bash

# Tourism Agency API Test Script
# Bu script API endpoint'lerini test etmek için kullanılır

BASE_URL="http://localhost:8080/api"

echo "==================================="
echo "Tourism Agency API Test Script"
echo "==================================="
echo ""

# Test 1: Create Hotel
echo "📝 Test 1: Creating a new hotel..."
curl -X POST $BASE_URL/hotels \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Grand Hotel Istanbul",
    "city": "Istanbul",
    "country": "Turkey",
    "address": "Taksim Square, Istanbul",
    "website": "https://grandhotel.com"
  }' | jq
echo ""

# Test 2: Get All Hotels
echo "📋 Test 2: Getting all hotels..."
curl -X GET $BASE_URL/hotels | jq
echo ""

# Test 3: Create Passenger
echo "📝 Test 3: Creating a new passenger..."
curl -X POST $BASE_URL/passengers \
  -H "Content-Type: application/json" \
  -d '{
    "passportNumber": "T12345678",
    "firstName": "Ahmet",
    "lastName": "Yılmaz",
    "dateOfBirth": "1990-05-15",
    "passportExpiryDate": "2028-12-31",
    "phone": "+905551234567",
    "email": "ahmet@example.com"
  }' | jq
echo ""

# Test 4: Get All Passengers
echo "📋 Test 4: Getting all passengers..."
curl -X GET $BASE_URL/passengers | jq
echo ""

# Test 5: Search Hotels by City
echo "🔍 Test 5: Searching hotels by city (Istanbul)..."
curl -X GET $BASE_URL/hotels/city/Istanbul | jq
echo ""

# Test 6: Get Upcoming Tours
echo "📋 Test 6: Getting upcoming tours..."
curl -X GET $BASE_URL/tours/upcoming | jq
echo ""

# Test 7: Get Passengers with Expiring Passports
echo "⚠️ Test 7: Getting passengers with expiring passports (90 days)..."
curl -X GET "$BASE_URL/passengers/expiring-passports?days=90" | jq
echo ""

echo "==================================="
echo "Tests completed!"
echo "==================================="
