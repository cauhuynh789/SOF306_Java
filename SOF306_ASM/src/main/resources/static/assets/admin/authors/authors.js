let host = "http://localhost:8080/rest";
const app = angular.module("app", []);
app.controller("authors-ctrl", ($scope, $http) => {
    $scope.form = {};
    $scope.items = [];

    $scope.reset = () => {
        $scope.form = {};
    };
    $scope.load_all = function() {
        var url = `${host}/authors`;
        $http
            .get(url)
            .then((resp) => {
                $scope.items = resp.data;
                console.log("Success", resp);
            })
            .catch((error) => {
                console.log("Error", error);
            });
    };

    $scope.edit = (authorId) => {
        var url = `${host}/authors/${authorId}`;
        $http
            .get(url)
            .then((resp) => {
                $scope.form = resp.data;
                console.log("Success", resp);
            })
            .catch((error) => {
                console.log("Error", error);
            });
    };
    $scope.create = () => {
        var item = angular.copy($scope.form);
        var url = `${host}/authors`;
        $http
            .post(url, item)
            .then((resp) => {
                $scope.items.push(item);
                $scope.reset();
                console.log("Success", resp);
            })
            .catch((error) => {
                console.log("Error", error);
            });
    };
    $scope.update = () => {
        var item = angular.copy($scope.form);
        var url = `${host}/authors/${$scope.form.authorId}`;
        $http
            .put(url, item)
            .then((resp) => {
                var index = $scope.items.findIndex(
                    (item) => item.authorId == $scope.form.authorId
                );
                $scope.items[index] = resp.data;
                console.log("Success", resp);
            })
            .catch((error) => {
                console.log("Error", error);
            });
    };

    $scope.delete = function(authorId) {
        var url = `${host}/authors/${$scope.form.authorId}`;
        $http
            .delete(url)
            .then((resp) => {
                var index = $scope.items.findIndex(
                    (item) => item.authorId == $scope.form.authorId
                );
                $scope.items.splice(index, 1);
                $scope.reset();
                console.log("Success", resp);
            })
            .catch((error) => {
                console.log("Error", error);
            });
    };
    // $scope.delete = (authorId) => {
    //     var url = `${host}/authors/${$scope.form.authorId}`;
    //     $http
    //         .delete(url)
    //         .then((resp) => {
    //             var index = $scope.items.findIndex(
    //                 (item) => item.authorId == $scope.form.authorId
    //             );
    //             $scope.items.splice(index, 1);
    //             $scope.reset();
    //             console.log("Success", resp);
    //         })
    //         .catch((error) => {
    //             console.log("Error", error);
    //         });
    // };

    $scope.imageChanged = function(files) {
        var data = new FormData();
        data.append("file", files[0]);
        $http
            .post("/rest/upload/images", data, {
                transformRequest: angular.identity,
                headers: { "Content-Type": undefined },
            })
            .then((resp) => {
                $scope.form.image = resp.data.name;
            })
            .catch((error) => {
                alert("Upload loi");
                console.log(error);
            });
    };

    $scope.load_all();
    $scope.reset();
});