select FirstName, LastName, City, State
from person p left join address a
on p.personId = a.personId