# AuthenticationApi

All URIs are relative to *http://localhost:8086*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**authenticate**](AuthenticationApi.md#authenticate) | **POST** /api/v1/auth/authenticate |  |
| [**getAuthentication**](AuthenticationApi.md#getAuthentication) | **GET** /api/v1/auth/info |  |
| [**logout**](AuthenticationApi.md#logout) | **POST** /api/v1/auth/logout |  |
| [**refreshToken**](AuthenticationApi.md#refreshToken) | **POST** /api/v1/auth/refresh-token |  |
| [**refreshTokenCookie**](AuthenticationApi.md#refreshTokenCookie) | **POST** /api/v1/auth/refresh-token-cookie |  |
| [**register**](AuthenticationApi.md#register) | **POST** /api/v1/auth/register |  |


<a id="authenticate"></a>
# **authenticate**
> AuthenticationResponse authenticate(authenticationRequest)



### Example
```java
// Import classes:
//import localhost.client.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

AuthenticationApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://localhost:8086"))).authentication();

api.authenticate()
    .body(authenticationRequest).execute(r -> r.prettyPeek());
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **authenticationRequest** | [**AuthenticationRequest**](AuthenticationRequest.md)|  | |

### Return type

[**AuthenticationResponse**](AuthenticationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*, application/json

<a id="getAuthentication"></a>
# **getAuthentication**
> getAuthentication(request)



### Example
```java
// Import classes:
//import localhost.client.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

AuthenticationApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://localhost:8086"))).authentication();

api.getAuthentication()
    .requestQuery(request).execute(r -> r.prettyPeek());
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **request** | [**AuthenticationRequest**](.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a id="logout"></a>
# **logout**
> logout()



### Example
```java
// Import classes:
//import localhost.client.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

AuthenticationApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://localhost:8086"))).authentication();

api.logout().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a id="refreshToken"></a>
# **refreshToken**
> RefreshTokenResponse refreshToken(refreshTokenRequest)



### Example
```java
// Import classes:
//import localhost.client.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

AuthenticationApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://localhost:8086"))).authentication();

api.refreshToken()
    .body(refreshTokenRequest).execute(r -> r.prettyPeek());
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **refreshTokenRequest** | [**RefreshTokenRequest**](RefreshTokenRequest.md)|  | |

### Return type

[**RefreshTokenResponse**](RefreshTokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a id="refreshTokenCookie"></a>
# **refreshTokenCookie**
> refreshTokenCookie()



### Example
```java
// Import classes:
//import localhost.client.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

AuthenticationApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://localhost:8086"))).authentication();

api.refreshTokenCookie().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a id="register"></a>
# **register**
> AuthenticationResponse register(registerRequest)



### Example
```java
// Import classes:
//import localhost.client.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

AuthenticationApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://localhost:8086"))).authentication();

api.register()
    .body(registerRequest).execute(r -> r.prettyPeek());
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **registerRequest** | [**RegisterRequest**](RegisterRequest.md)|  | |

### Return type

[**AuthenticationResponse**](AuthenticationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

