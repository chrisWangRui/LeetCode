
/* 175. Combine Two Tables */
SELECT Person.FirstName, Person.LastName, Address.City, Address.State FROM Person LEFT JOIN Address ON Person.PersonID=Address.PersonID;

/* 176. Second Highest Salary */
SELECT MAX(Salary) AS SecondHighestSalary FROM (SELECT Salary FROM Employee WHERE Salary<(SELECT MAX(Salary) FROM Employee)ORDER BY Salary DESC);

/* 177. Nth Highest Salary */
CREATE FUNCTION getNthHighestSalary(N IN INT) RETURN INT IS
result INT;
BEGIN
       SELECT Salary INTO result FROM (SELECT Salary, ROWNUM AS num FROM (SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC) WHERE ROWNUM<=N) WHERE num=N;
        RETURN result;
 END;

/* 178. Rank Scores */
SELECT Score, (SELECT count(DISTINCT score) FROM Scores WHERE score >= s.score) AS Rank FROM Scores s ORDER BY Score DESC ;

