INSERT INTO public.employee (
first_name, last_name) VALUES(
'Alex'::character varying, 'Kim'::character varying)
 returning id;

INSERT INTO public.user_access (
email, is_active, password, role, username, employee_id) VALUES (
'admin@samarkanda-travel.com'::character varying, true::boolean, '$2a$10$pwrLQ0/GeCsUzC8KgYzqOelmMS1ji1V4nb3Dn5slU24JW2Zb6mW1.'::character varying, 'ROLE_ADMIN'::character varying, 'admin'::character varying, 1::bigint)
 returning id;