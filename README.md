# jackson-troubleshoot

When attempting to parse a JSON, when one of the fields sometimes have a value that spans over 10K characters, I notice that the field value gets truncated to 10K characters.

Haven't been able to pinpoint exactly why at the time of writing..

Bug report: https://github.com/FasterXML/jackson-core/issues/641
