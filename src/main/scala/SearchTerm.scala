opaque type SearchTerm = String

extension (searchTerm: SearchTerm)
  def isIncluded(textToSearch: String): Boolean =
    textToSearch.contains(searchTerm)

  def isFullMatch(textToSearch: String): Boolean =
    textToSearch == searchTerm

  def isCaseInsensitiveMatch(textToSearch: String): Boolean =
    textToSearch.equalsIgnoreCase(searchTerm)

  def startsWith(textToSearch: String): Boolean =
    textToSearch.startsWith(searchTerm)

  def endsWith(textToSearch: String): Boolean =
    textToSearch.endsWith(searchTerm)

object SearchTerm:
  def fromTerm(searchTerm: String): SearchTerm =
    searchTerm
