import re

text = """
John's birthdate is 05/14/1990 and his anniversary is also 05/14/1990.
Sarah's birthdate is 07/22/1985 and her anniversary is 08/15/2010.
"""

pattern = r'\b(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(\d{4})\b.*?\b\1/\2/\3\b'

matches = re.findall(pattern, text)
print("Consistent date pairs found:", matches)

