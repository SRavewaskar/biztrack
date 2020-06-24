# bizTrack-srewaskar1
BizTrack is an extremely primitive Invoicing Platform

It is an open API Platform to all it's developers (1st and 3rd party alike). That implies that all it's Invoicing APIs are publicly available. 

The idea of the platform is very simple. It provides API to track Invoices, Payments & Customers.  
Invoices - `/invoices/*`  
Payments - `/payments/*`  
Customers - `/customers/*` 

When an invoice gets created for a customer, Customer's open balance increases. When a payment is made towards that invoice, the customer's open balance drops by the amount paid. For simplicity, there are no partial payments and you can only have one full payment for an open invoice.
