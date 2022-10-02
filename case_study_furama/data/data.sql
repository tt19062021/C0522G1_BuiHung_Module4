use blog_manager;
select b.id,b.title,b.author,b.date_of_writing, c.category_name from blog b
join category c on c.id = b.category_id;