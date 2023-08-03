const app = angular.module("admin-app", ["ngRoute"]);
app.config($routeProvider => {
    $routeProvider
    .when("/accounts", {
        templateUrl: "/assets/admin/accounts/index.html",
        controller: "accounts-ctrl"
    })
    .when("/books", {
        templateUrl: "/assets/admin/books/index.html",
        controller: "books-ctrl"
    })
    .when("/authorize", {
        templateUrl: "/assets/admin/authority/index.html",
        controller: "authority-ctrl"
    })
    .when("/unauthorized", {
        templateUrl: "/assets/admin/authority/unauthorized.html",
        controller: "authority-ctrl"
    })
    .otherwise({
        template: "<h1 class='text-center'>Administration</h1>"
    });
});