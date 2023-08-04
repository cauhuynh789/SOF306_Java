app.controller("accounts-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.form = {};
    $scope.load = () => {
        // load accounts
        $http.get("/api/accounts").then(resp => {
            $scope.items = resp.data;
        });
    }

    $scope.reset = () => {
        $scope.form = {gender: true, photo: "default.jpg", status: true};
    }

    $scope.edit = (accountId) => {
        $http.get("/api/accounts/" + accountId).then(resp => {
            $scope.form = resp.data;
            console.log("Success", resp);
            window.scrollTo(0, 0);
        }).catch(error => {
            console.log("Error", error);
        });
    }

    $scope.create = () => {
        var item = angular.copy($scope.form);
        $http.post("/api/accounts", item).then(resp => {
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
        $http.put("/api/accounts/" + item.accountId, item).then(resp => {
            var index = $scope.items.findIndex(p => p.accountId = item.accountId);
            $scope.items[index] = item;
            $scope.load()
            alert("Cập nhật sản phẩm thành công");
        }, error => {
            alert("Cập nhật sản phẩm thất bại");
            console.log("Error", error);
        });
    }

    $scope.delete = (accountId) => {
        $http.delete("/api/accounts/" + accountId).then(resp => {
            var index = $scope.items.findIndex(item => item.accountId == accountId);
            $scope.items.splice(index, 1);
            $scope.reset();
            console.log("Success", resp);
            alert("Xoá sản phẩm thành công");
        }).catch(error => {
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
    $scope.load();
    $scope.reset();
});