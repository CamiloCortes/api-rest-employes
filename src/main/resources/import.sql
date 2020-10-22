insert into roles (descripcion) values ('Jefe Operaciones')
insert into roles (descripcion) values ('Operario')
insert into employes (fullname, email, role_id)		  values ('Samuel Morales','Boss1@gmail.com',(select id from roles where descripcion = 'Jefe Operaciones') )
insert into employes (fullname, email, role_id, id_boss) values ('Ricardo Puentes','operario1@gmail.com',(select id from roles where descripcion = 'Operario'),1 )
insert into employes (fullname, email, role_id, id_boss) values ('Miguel Forero','operario2@gmail.com',(select id from roles where descripcion = 'Operario'),1 )

