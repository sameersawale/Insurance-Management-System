This is insurance management backend application using Spring boot and MySQL.
Create database in MySQL name="imt_assignment"

In this application I used role based authentication before using all the endpoints create admin/user 
by using following endpoint:

	localhost:8080/user/add  (username, password, role)
	if you want to register as a admin then specify role:"ROLE_ADMIN" and for user: "ROLE_USER"

Admin can access all the end points whereas User can also access all except getAll.

following are the all endpoints

1. for client
	1)add	  	localhost:8080/client/add
	2)getById  	localhost:8080/client/get/{id}
	3)getAll	localhost:8080/client/getAll  (only access admin)
	4)update	localhost:8080/client/edit/{id}
	5)delete	localhost:8080/client/delete/{id}

2. for insurance policy
	1)add	  	localhost:8080/insurance/add
	2)getById  	localhost:8080/insurance/get/{id}
	3)getAll	localhost:8080/insurance/getAll  (only access admin)
	4)update	localhost:8080/insurance/edit/{id}
	5)delete	localhost:8080/insurance/delete/{id}

3. for claim
	1)add	  	localhost:8080/claim/add
	2)getById  	localhost:8080/claim/get/{id}
	3)getAll	localhost:8080/claim/getAll  (only access admin)
	4)update	localhost:8080/claim/edit/{id}
	5)delete	localhost:8080/claim/delete/{id}