app.controller("accounts-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.form = {};
    $scope.init = () => {
        // load products
        $http.get("/api/accounts").then(resp => {
            $scope.items = resp.data;
        });
    }

    $scope.reset = () => {
        $scope.form = {gender: true, photo: "default.jpg", status: true};
    }

    $scope.edit = (item) => {
        $http.get('/api/accounts/${item}').then(resp => {
            $scope.form = resp.data;
            console.log("Success", resp);
        }).catch(error => {
            console.log("Error", error);
        });
    }

    $scope.create = () => {
        var item = angular.copy($scope.form);
        $http.post("/api/products", item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate);
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm sản phẩm thành công");
        }, error => {
            alert("Thêm sản phẩm thất bại");
            console.log("Error", error);
        });
    }

    $scope.update = () => {
        var item = angular.copy($scope.form);
        $http.put("/api/products/" + item.id, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id = item.id);
            $scope.items[index] = item;
            alert("Cập nhật sản phẩm thành công");
        }, error => {
            alert("Cập nhật sản phẩm thất bại");
            console.log("Error", error);
        });
    }

    $scope.remove = (item) => {
        var item = angular.copy($scope.form);
        $http.delete("/api/products/" + item.id).then(resp => {
            var index = $scope.items.findIndex(p => p.id = item.id);
            $scope.items.splice(index, 1);
            $scope.reset();
            alert("Xoá sản phẩm thành công");
        }, error => {
            alert("Xoá sản phẩm thất bại");
            console.log("Error", error);
        });
    }

    $scope.imageChanged = (files) => {
        var form = new FormData();
        form.append("file", files[0]);

        $http.post("/api/upload/images", form, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        }).then(resp => {
            $scope.form.photo = resp.data.name;
        }, error => {
            alert("Lỗi upload hình");
            console.log("Error", error);
        });
    }
    $scope.pager = {
        page: 0,
        size: 10,
        get items() {
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first() {
            this.page = 0;
        },
        prev() {
            this.page--;
            if (this.page < 0) {
                this.last();
            }
        },
        next() {
            this.page++;
            if (this.page >= this.count) {
                this.first();
            }
        },
        last() {
            this.page = this.count - 1;
        }
    }
    $scope.init();
});