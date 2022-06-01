# fullstackProject
Hi This is new Project Welcome .... Amit

******Database name-----Shopping_Portal******


table 1. Product_master---> Prd_Id, Prd_name, Prd_desc, prd_rate, prd_aval, prd_Cat_id, prd_ed, prd_img , prd_img_extension ------ Abhishek

table 2. category_master ---> cat_id, cat_name, parent_cat_id -----Abhishek

table 3. offer_master  ---> offer_id, cat_id ,offer_deatil, offer_s_date, offer_e_date -----Tarun

table 4. cart_master ====> cart_id, user_id, prd_id, prd_quantity  ------ Amit

table 5. billing_master -----> bill_id, user_id, amount, products{prd1,prd2}, bill_date  -----Tarun

table 6. user_master ----> user_id, user_name, user_mobile, user_address, user_email, user_type, user_pass ----Amit


********Add modify_by, modify_time in every table********

Controller :

ProductController  --- Abhishek
services - getAllProduct, updateProduct, getProductById, getProductByCategory

CategoryController -----  getAllCategories, updateCategory-------Abhishek

Offer master --- getOffer, UpdateOffer, getOfferByCategory  ---Tarun

Cart Master ---- updateCart and addCart   ----- Amit

Billing master ----  getBillByUserId   ----   Tarun

user Table -- addUser, updateUser, getUserByRole, getUsernameByEmail   ---- Amit

