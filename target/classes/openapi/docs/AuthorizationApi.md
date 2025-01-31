# AuthorizationApi

All URIs are relative to *http://localhost:8086*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**sayHelloWithRoleAdminAndDeleteAuthority**](AuthorizationApi.md#sayHelloWithRoleAdminAndDeleteAuthority) | **DELETE** /api/v1/admin/resource |  |
| [**sayHelloWithRoleAdminAndReadAuthority**](AuthorizationApi.md#sayHelloWithRoleAdminAndReadAuthority) | **GET** /api/v1/admin/resource | Hello secured endpoint |
| [**sayHelloWithRoleUserAndCreateAuthority**](AuthorizationApi.md#sayHelloWithRoleUserAndCreateAuthority) | **POST** /api/v1/user/resource |  |
| [**sayHelloWithRoleUserAndUpdateAuthority**](AuthorizationApi.md#sayHelloWithRoleUserAndUpdateAuthority) | **PUT** /api/v1/user/resource |  |


<a id="sayHelloWithRoleAdminAndDeleteAuthority"></a>
# **sayHelloWithRoleAdminAndDeleteAuthority**
> String sayHelloWithRoleAdminAndDeleteAuthority()



### Example
```java
// Import classes:
//import localhost.client.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

AuthorizationApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://localhost:8086"))).authorization();

api.sayHelloWithRoleAdminAndDeleteAuthority().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a id="sayHelloWithRoleAdminAndReadAuthority"></a>
# **sayHelloWithRoleAdminAndReadAuthority**
> String sayHelloWithRoleAdminAndReadAuthority()

Hello secured endpoint

This endpoint require a valid JWT, ADMIN role with READ_PRIVILEGE

### Example
```java
// Import classes:
//import localhost.client.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

AuthorizationApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://localhost:8086"))).authorization();

api.sayHelloWithRoleAdminAndReadAuthority().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a id="sayHelloWithRoleUserAndCreateAuthority"></a>
# **sayHelloWithRoleUserAndCreateAuthority**
> String sayHelloWithRoleUserAndCreateAuthority()



### Example
```java
// Import classes:
//import localhost.client.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

AuthorizationApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://localhost:8086"))).authorization();

api.sayHelloWithRoleUserAndCreateAuthority().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a id="sayHelloWithRoleUserAndUpdateAuthority"></a>
# **sayHelloWithRoleUserAndUpdateAuthority**
> String sayHelloWithRoleUserAndUpdateAuthority()



### Example
```java
// Import classes:
//import localhost.client.invoker.ApiClient;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.ErrorLoggingFilter;

AuthorizationApi api = ApiClient.api(ApiClient.Config.apiConfig().withReqSpecSupplier(
                () -> new RequestSpecBuilder()
                        .setBaseUri("http://localhost:8086"))).authorization();

api.sayHelloWithRoleUserAndUpdateAuthority().execute(r -> r.prettyPeek());
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

