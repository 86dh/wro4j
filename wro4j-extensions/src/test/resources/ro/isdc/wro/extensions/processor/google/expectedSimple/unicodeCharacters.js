'use strict';var WHITESPACE_CHARS=array_to_hash(characters(" \u00a0\n\r\t\f\v\u200b\u180e\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200a\u202f\u205f\u3000")),PUNC_BEFORE_EXPRESSION=array_to_hash(characters("[{}(,.;:")),PUNC_CHARS=array_to_hash(characters("[]{}(),;:")),REGEXP_MODIFIERS=array_to_hash(characters("gmsiy"));