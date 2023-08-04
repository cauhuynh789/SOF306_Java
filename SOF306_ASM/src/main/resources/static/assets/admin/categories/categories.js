let host = "http://localhost:8080/rest";
const app = angular.module("app", []);
app.controller("ctrl", ($scope, $http) => {
    $scope.form = {};
    $scope.items = [];
    $scope.reset = () => {
        $scope.form = {gender: true, photo: "default.jpg", status: true, roleId: true};
    }
    $scope.load_all = () => {
        var url = `${host}/categories`    ;
        $http.get(url).then(resp => {
            $scope.items = resp.data;
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }
    $scope.edit = (categoryId) => {
        var url = `${host}/categories/${categoryId}`;
        $http.get(url).then(resp => {
            $scope.form = resp.data;
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }
    $scope.create = () => {
        var item = angular.copy($scope.form);
        var url = `${host}/categories`;
        $http.post(url, item).then(resp => {
            $scope.items.push(item);
            $scope.reset();
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });        
    }
    $scope.update = () => {
        var item = angular.copy($scope.form);
        var url = `${host}/categories/${$scope.form.categoryId}`;
        $http.put(url, item).then(resp => {
            var index = $scope.items.findIndex(item => item.categoryId == $scope.form.categoryId);
            $scope.items[index] = resp.data;
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }
    $scope.delete = (categoryId) => {
        var url = `${host}/categories/${$scope.form.categoryId}`;
        $http.delete(url).then(resp => {
            var index = $scope.items.findIndex(item => item.categoryId == $scope.form.categoryId);
            $scope.items.splice(index, 1);
            $scope.reset();
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }

    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            alert("Upload loi");
            console.log(error);
        })
    }

    $scope.load_all();
    $scope.reset();
});

