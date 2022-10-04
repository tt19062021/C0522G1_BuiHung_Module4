select af.name, c.deposit, c.start_date , c.end_date, af.cost from attach_facility af 
join contract_detail cd 
on af.id = cd.attach_facility_id 
join contract c 
on cd.contract_id = c.id;