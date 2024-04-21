# test-script-endpoints.ps1
## This script tests the endpoints of the application.

# Start of a section
Write-Host "-------------------------"
Write-Host "Start: register a new user"
Write-Host "-------------------------"
# Register a new user
$body = @{
  username = "testUser"
  city = "Test City"
  state = "Test State"
  zipCode = 12345
  allergyPeanut = $true
  allergyEgg = $false
  allergyDairy = $false
} | ConvertTo-Json
Invoke-RestMethod -Uri "http://localhost:8080/api/users/register" -Method POST -Body $body -ContentType "application/json"
Write-Host "-------------------------"
Write-Host "End: register a new user"
Write-Host "-------------------------"
# End of a section

# Start of a section
Write-Host "-------------------------"
Write-Host "Start: get user by username"
Write-Host "-------------------------"
# Get user by username
$username = "testUser"
Invoke-RestMethod -Uri "http://localhost:8080/api/users/$username" -Method GET
# End of a section
Write-Host "-------------------------"
Write-Host "End: get user by username"
Write-Host "-------------------------"

# Start of a section
Write-Host "-------------------------"
Write-Host "Start: register a new restaurant"
Write-Host "-------------------------"
# Register a new restaurant
$body = @{
  restaurantName = "Test Restaurant"
} | ConvertTo-Json
Invoke-RestMethod -Uri "http://localhost:8080/api/restaurant/register" -Method POST -Body $body -ContentType "application/json"
# End of a section
Write-Host "-------------------------"
Write-Host "End: register a new restaurant"
Write-Host "-------------------------"

# Start of a section
Write-Host "-------------------------"
Write-Host "Start: get all restaurants"
Write-Host "-------------------------"
# Get all restaurants
Invoke-RestMethod -Uri "http://localhost:8080/api/restaurant" -Method GET
# End of a section
Write-Host "-------------------------"
Write-Host "End: get all restaurants"
Write-Host "-------------------------"

# Start of a section
Write-Host "-------------------------"
Write-Host "Start: submit a new review"
Write-Host "-------------------------"
# Submit a new review
$body = @{
  reviewerName = "Test Reviewer"
  restaurantId = 1
  scorePeanut = 5
  scoreEgg = 4
  scoreDairy = 3
  reviewCommentary = "I love the strawberry milk!"
  status = "PENDING"
} | ConvertTo-Json
$response = Invoke-RestMethod -Uri "http://localhost:8080/api/reviews/submit?username=testUser" -Method POST -Body $body -ContentType "application/json"
$reviewId = $response.reviewId # Extract the reviewId from the response
# End of a section
Write-Host "-------------------------"
Write-Host "End: submit a new review"
Write-Host "-------------------------"

# Start of a section
Write-Host "-------------------------"
Write-Host "Start: get all reviews"
Write-Host "-------------------------"
# Get all reviews
Invoke-RestMethod -Uri "http://localhost:8080/api/reviews" -Method GET
# End of a section
Write-Host "-------------------------"
Write-Host "End: get all reviews"
Write-Host "-------------------------"

# Start of a section
Write-Host "-------------------------"
Write-Host "Start: get all pending reviews"
Write-Host "-------------------------"
# Get all pending reviews
Invoke-RestMethod -Uri "http://localhost:8080/api/reviews/pending" -Method GET
# End of a section
Write-Host "-------------------------"
Write-Host "End: get all pending reviews"
Write-Host "-------------------------"

# Start of a section
Write-Host "-------------------------"
Write-Host "Start: set admin review status"
Write-Host "-------------------------"
# Set admin review status
$body = @{
  isApproved = $true # or $false
} | ConvertTo-Json
# Make sure the reviewId exists in the database
Invoke-RestMethod -Uri "http://localhost:8080/api/admin/review/$reviewId" -Method PUT -Body $body -ContentType "application/json"
# End of a section
Write-Host "-------------------------"
Write-Host "End: set admin review status"
Write-Host "-------------------------"

# Start of a section
Write-Host "-------------------------"
Write-Host "Start: delete user by username"
Write-Host "-------------------------"
# Delete user by username
$username = "testUser"
Invoke-RestMethod -Uri "http://localhost:8080/api/users/$username" -Method DELETE
# End of a section
Write-Host "-------------------------"
Write-Host "End: delete user by username"
Write-Host "-------------------------"