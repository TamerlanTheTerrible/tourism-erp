INSERT INTO public.user_access (
email, is_active, password, role, username) VALUES (
'admin@samarkanda-travel.com'::character varying, true::boolean, 'admin'::character varying, 'ROLE_ADMIN'::character varying, 'admin'::character varying)
 returning id;